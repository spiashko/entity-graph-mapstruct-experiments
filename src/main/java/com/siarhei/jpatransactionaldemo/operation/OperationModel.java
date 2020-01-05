package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountModel;
import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationModel extends BaseJournalModel {

    private BankAccountModel bankAccount;
    private Long bankAccountId;
    private Long amount;
    private OperationSource operationSource;
    private Long fkOperationSource;


}
