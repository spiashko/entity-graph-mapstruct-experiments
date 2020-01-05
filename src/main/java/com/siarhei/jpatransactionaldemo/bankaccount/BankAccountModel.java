package com.siarhei.jpatransactionaldemo.bankaccount;

import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountModel extends BaseJournalModel {

    private Long balance;
    private List<MoneyTransferModel> outMoneyTransfers;
    private List<MoneyTransferModel> inMoneyTransfers;

}
