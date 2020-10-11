package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountManagementService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.*;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewCModel;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewCSearchService;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MoneyTransferTests extends BaseApplicationTest {

    @Autowired
    private OperationViewCSearchService operationViewCSearchService;
    @Autowired
    private BankAccountManagementService bankAccountManagementService;
    @Autowired
    private MoneyTransferManagementService managementService;
    @Autowired
    private MoneyTransferSearchService searchService;

    @Test
    void givenTwoAccounts_whenCreateMoneyTransfer_thenCreated() {
        //given
        BankAccountViewAModel accountFrom =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        BankAccountViewAModel accountTo =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(200L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        MoneyTransferViewBModel moneyTransfer =
                managementService.createMoneyTransfer(MoneyTransferCreationModel.builder()
                        .fromBankAccountId(accountFrom.getId())
                        .toBankAccountId(accountTo.getId())
                        .amount(10L)
                        .build());

        //then
        // select bank account from
        // select bank account to
        // insert operation from
        // insert operation to
        // insert money transfer
        // total 5
        SQLStatementCountValidator.assertInsertCount(3);
        Assertions.assertEquals(5, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertNotNull(moneyTransfer);
        Assertions.assertNotNull(moneyTransfer.getId());
        Assertions.assertEquals(10L, moneyTransfer.getAmount());

        List<OperationViewCModel> operations = operationViewCSearchService.findAll(OperationViewCModel.class);
        Assertions.assertEquals(2, operations.size());

        OperationViewCModel sendOperation = operations.stream()
                .filter(o -> o.getSendMoneyTransfer() != null)
                .findFirst()
                .orElse(null);
        Assertions.assertNotNull(sendOperation);
        Assertions.assertEquals(moneyTransfer.getId(), sendOperation.getSendMoneyTransfer().getId());
        Assertions.assertEquals(accountFrom.getId(), sendOperation.getBankAccount().getId());
        Assertions.assertEquals(moneyTransfer.getAmount(), sendOperation.getAmount());

        OperationViewCModel receiveOperation = operations.stream()
                .filter(o -> o.getReceiveMoneyTransfer() != null)
                .findFirst()
                .orElse(null);
        Assertions.assertNotNull(receiveOperation);
        Assertions.assertEquals(moneyTransfer.getId(), receiveOperation.getReceiveMoneyTransfer().getId());
        Assertions.assertEquals(accountTo.getId(), receiveOperation.getBankAccount().getId());
        Assertions.assertEquals(moneyTransfer.getAmount(), receiveOperation.getAmount());
    }

    @Test
    void givenOneMoneyTransfer_whenFindMoneyTransferViewX_thenOnlyOneSqlExecuted() {
        //given
        BankAccountViewAModel accountFrom =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        BankAccountViewAModel accountTo =
                bankAccountManagementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(200L)
                        .build());
        MoneyTransferViewBModel createResponse =
                managementService.createMoneyTransfer(MoneyTransferCreationModel.builder()
                        .fromBankAccountId(accountFrom.getId())
                        .toBankAccountId(accountTo.getId())
                        .amount(10L)
                        .build());
        SQLStatementCountValidator.reset();

        //when-then
        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findAll(MoneyTransferViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findAll(MoneyTransferViewBModel.class));

        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findOneOrThrow(createResponse.getId(), MoneyTransferViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findOneOrThrow(createResponse.getId(), MoneyTransferViewBModel.class));
    }

}
