package com.siarhei.jpatransactionaldemo.cash;

public interface CashActionManagementService<R extends CashActionModel, T extends CreateCashActionModel> {

    R createCashAction(T createModel);

}
