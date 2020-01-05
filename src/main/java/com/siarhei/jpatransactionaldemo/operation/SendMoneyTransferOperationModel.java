package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMoneyTransferOperationModel extends OperationModel {

    private MoneyTransferModel moneyTransfer;

    @Builder
    public SendMoneyTransferOperationModel(BankAccountModel bankAccount, Long bankAccountId, Long amount, OperationSource operationSource, Long fkOperationSource, MoneyTransferModel moneyTransfer) {
        super(bankAccount, bankAccountId, amount, operationSource, fkOperationSource);
        this.moneyTransfer = moneyTransfer;
    }
}
