package com.siarhei.jpatransactionaldemo.cash;

public interface CashActionManagementService<E extends CashAction, T extends CashActionCreationModel> {

    E createCashAction(T creationModel);

}
