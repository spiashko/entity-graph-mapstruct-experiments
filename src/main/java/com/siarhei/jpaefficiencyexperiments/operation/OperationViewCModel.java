package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.cash.ActionType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OperationViewCModel {

    private UUID id;
    private BankAccountModel bankAccount;
    private Long amount;
    private OperationSource operationSource;
    private MoneyTransferModel sendMoneyTransfer;
    private MoneyTransferModel receiveMoneyTransfer;
    private CashWithdrawalModel cashWithdrawal;
    private CashRefillModel cashRefill;

    @Getter
    @Setter
    public static class BankAccountModel {
        private UUID id;
        private Long balance;
    }

    @Getter
    @Setter
    public static class CashRefillModel {
        private UUID id;
        private Long cashAmount;
        private ActionType actionType;
    }

    @Getter
    @Setter
    public static class CashWithdrawalModel {
        private UUID id;
        private Long cashAmount;
        private Long fee;
        private ActionType actionType;
    }

    @Getter
    @Setter
    public static class MoneyTransferModel {
        private UUID id;
        private Long amount;
    }

}
