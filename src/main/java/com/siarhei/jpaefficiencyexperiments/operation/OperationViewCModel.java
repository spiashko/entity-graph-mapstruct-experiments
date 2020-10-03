package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.cash.ActionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationViewCModel {

    private Long id;
    private BankAccountModel bankAccount;
    private Long amount;
    private OperationSource operationSource;
    private MoneyTransferModel sendMoneyTransfer;
    private MoneyTransferModel receiveMoneyTransfer;
    private CashActionModel cashWithdrawal;
    private CashActionModel cashRefill;

    @Getter
    @Setter
    public static class BankAccountModel {
        private Long id;
        private Long balance;
    }

    @Getter
    @Setter
    public static class CashActionModel {
        private Long id;
        private Long cashAmount;
        private Long fee;
        private ActionType actionType;
    }

    @Getter
    @Setter
    public static class MoneyTransferModel {
        private Long id;
        private Long amount;
    }

}
