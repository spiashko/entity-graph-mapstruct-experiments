package com.siarhei.jpatransactionaldemo.web.dto.operation;

import com.siarhei.jpatransactionaldemo.cash.ActionType;
import com.siarhei.jpatransactionaldemo.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationViewCDto {

    private Long id;
    private BankAccountDto bankAccount;
    private Long amount;
    private OperationSource operationSource;
    private MoneyTransferDto sendMoneyTransfer;
    private MoneyTransferDto receiveMoneyTransfer;
    private CashActionDto cashWithdrawal;
    private CashActionDto cashRefill;

    @Getter
    @Setter
    public static class BankAccountDto {
        private Long id;
        private Long balance;
    }

    @Getter
    @Setter
    public static class CashActionDto {
        private Long id;
        private Long cashAmount;
        private Long fee;
        private ActionType actionType;
    }

    @Getter
    @Setter
    public static class MoneyTransferDto {
        private Long id;
        private Long amount;
    }

}
