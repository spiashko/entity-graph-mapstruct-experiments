package com.siarhei.jpatransactionaldemo.moneytransfer.base;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchService;

public interface BaseMoneyTransferSearchService<E extends BaseMoneyTransfer, F extends BaseMoneyTransferFilter>
        extends BaseSearchService<E, F> {

}
