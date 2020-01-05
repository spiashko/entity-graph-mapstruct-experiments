package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;
import com.siarhei.jpatransactionaldemo.operation.ReceiveMoneyTransferOperationModel;
import com.siarhei.jpatransactionaldemo.operation.SendMoneyTransferOperationModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransferModel extends BaseJournalModel {

    private SendMoneyTransferOperationModel sendOperation;
    private ReceiveMoneyTransferOperationModel receiveOperation;
    private Long amount;

}
