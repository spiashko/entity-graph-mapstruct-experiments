package com.siarhei.jpatransactionaldemo.cash;

import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;

public class CashActionModel extends BaseJournalModel {

    private Long cashAmount;
    private Long fee;
    private ActionType actionType;

}
