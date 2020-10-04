package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountManagementService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.BaseCashActionViewBModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashActionCreationService;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CashActionTests extends BaseApplicationTest {

    @Autowired
    private CashActionCreationService<CashRefillViewBModel, CashRefillCreationModel> cashRefillManagementService;
    @Autowired
    private BankAccountManagementService bankAccountManagementService;

    @Test
    void given_one_account_when_create_cash_refill_then_created() {
        //given
        BankAccountViewAModel createResponse =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        CashRefillViewBModel cashRefill = cashRefillManagementService.createCashAction(
                CashRefillCreationModel.builder()
                        .bankAccountId(createResponse.getId())
                        .cashAmount(100L)
                        .build());

        //then
        SQLStatementCountValidator.assertInsertCount(2);
        Assertions.assertEquals(3, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertNotNull(cashRefill);
        Assertions.assertNotNull(cashRefill.getId());
        Assertions.assertEquals(100L, cashRefill.getCashAmount());
        BaseCashActionViewBModel.CashActionOperationModel cashRefillOperation = cashRefill.getCashRefillOperation();
        Assertions.assertNotNull(cashRefillOperation);
        Assertions.assertNotNull(cashRefillOperation.getId());
        Assertions.assertEquals(100L, cashRefillOperation.getAmount());
        Assertions.assertEquals(createResponse.getId(), cashRefillOperation.getBankAccountId());
    }

}
