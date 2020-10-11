package com.siarhei.jpaefficiencyexperiments.cash;

public interface BaseCashActionCreationService<R extends BaseCashActionViewBModel, T extends BaseCashActionCreationModel> {

    R createCashAction(T creationModel);

}
