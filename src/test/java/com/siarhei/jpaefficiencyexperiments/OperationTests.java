package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountManagementService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.*;
import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchService;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import com.siarhei.jpaefficiencyexperiments.operation.*;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OperationTests extends BaseApplicationTest {

    @Autowired
    private OperationSummarySearchService operationSummarySearchService;
    @Autowired
    private OperationViewCSearchService operationViewCSearchService;
    @Autowired
    private MoneyTransferManagementService moneyTransferManagementService;
    @Autowired
    private CashRefillCreationService cashRefillManagementService;
    @Autowired
    private CashWithdrawalCreationService cashWithdrawalManagementService;
    @Autowired
    private BankAccountManagementService bankAccountManagementService;

    @Test
    void givenCashRefillWithdrawalMoneyTransfer_whenFindAllOperationViewXModel_thenOnlyOneSqlExecuted() {
        //given
        BankAccountViewAModel accountOne =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        BankAccountViewAModel accountTwo =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(200L)
                        .build());
        CashRefillViewBModel cashRefill =
                cashRefillManagementService.createCashAction(
                        CashRefillCreationModel.builder()
                                .bankAccountId(accountOne.getId())
                                .cashAmount(100L)
                                .build());
        CashWithdrawalViewBModel cashWithdrawal = cashWithdrawalManagementService.createCashAction(
                CashWithdrawalCreationModel.builder()
                        .bankAccountId(accountOne.getId())
                        .cashAmount(100L)
                        .build());
        MoneyTransferViewBModel moneyTransfer =
                moneyTransferManagementService.createMoneyTransfer(MoneyTransferCreationModel.builder()
                        .fromBankAccountId(accountOne.getId())
                        .toBankAccountId(accountTwo.getId())
                        .amount(10L)
                        .build());

        //when-then
        assertOperationSelectCount(OperationViewAModel.class, operationSummarySearchService);
        assertOperationSelectCount(OperationViewBModel.class, operationSummarySearchService);
        assertOperationSelectCount(OperationViewCModel.class, operationViewCSearchService);
    }

    private <T> void assertOperationSelectCount(Class<T> clazz, BaseSearchService<?> searchService) {
        //given
        SQLStatementCountValidator.reset();

        //when
        List<T> all = searchService.findAll(clazz);

        //then
        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertEquals(4, all.size());
    }

}
