package com.siarhei.jpaefficiencyexperiments.cash;

public interface CashActionManagementService<E extends CashAction, T extends CashActionCreationModel> {

    E createCashAction(T creationModel);

}
