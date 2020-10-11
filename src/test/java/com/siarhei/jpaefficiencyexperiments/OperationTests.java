package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountManagementService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountSearchService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.*;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import com.siarhei.jpaefficiencyexperiments.operation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationTests extends BaseApplicationTest {

    @Autowired
    private BankAccountSearchService bankAccountSearchService;
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
    void givenCashRefillWithdrawalMoneyTransfer_whenFindOperationViewX_thenOnlyOneSqlExecuted() {
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
        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findAll(OperationViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findAll(OperationViewBModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationViewCSearchService.findAll(OperationViewCModel.class));

        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(cashRefill.getCashRefillOperation().getId(), OperationViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(cashRefill.getCashRefillOperation().getId(), OperationViewBModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationViewCSearchService.findOneOrThrow(cashRefill.getCashRefillOperation().getId(), OperationViewCModel.class));

        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(cashWithdrawal.getCashWithdrawalOperation().getId(), OperationViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(cashWithdrawal.getCashWithdrawalOperation().getId(), OperationViewBModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationViewCSearchService.findOneOrThrow(cashWithdrawal.getCashWithdrawalOperation().getId(), OperationViewCModel.class));

        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(moneyTransfer.getSendOperation().getId(), OperationViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(moneyTransfer.getSendOperation().getId(), OperationViewBModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationViewCSearchService.findOneOrThrow(moneyTransfer.getSendOperation().getId(), OperationViewCModel.class));

        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(moneyTransfer.getReceiveOperation().getId(), OperationViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationSummarySearchService.findOneOrThrow(moneyTransfer.getReceiveOperation().getId(), OperationViewBModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> operationViewCSearchService.findOneOrThrow(moneyTransfer.getReceiveOperation().getId(), OperationViewCModel.class));

        BankAccountViewAModel accountOneAfter = bankAccountSearchService.findOneOrThrow(accountOne.getId(), BankAccountViewAModel.class);
        Assertions.assertEquals(89L, accountOneAfter.getBalance());
        BankAccountViewAModel accountTwoAfter = bankAccountSearchService.findOneOrThrow(accountTwo.getId(), BankAccountViewAModel.class);
        Assertions.assertEquals(210L, accountTwoAfter.getBalance());
    }

}
