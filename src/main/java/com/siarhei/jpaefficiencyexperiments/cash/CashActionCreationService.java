package com.siarhei.jpaefficiencyexperiments.cash;

public interface CashActionCreationService<R extends BaseCashActionViewBModel, T extends BaseCashActionCreationModel> {

    R createCashAction(T creationModel);

}
