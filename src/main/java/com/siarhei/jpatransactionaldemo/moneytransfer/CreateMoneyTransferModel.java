package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMoneyTransferModel extends BaseJournalModel {

    private Long fromBankAccountId;
    private Long toBankAccountId;
    private Long amount;

}
