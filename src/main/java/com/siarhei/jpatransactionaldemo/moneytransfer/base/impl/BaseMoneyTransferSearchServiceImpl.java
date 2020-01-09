package com.siarhei.jpatransactionaldemo.moneytransfer.base.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransferFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransferSearchService;

public abstract class BaseMoneyTransferSearchServiceImpl<
        E extends BaseMoneyTransfer,
        F extends BaseMoneyTransferFilter,
        S extends BaseMoneyTransferSpec<E, F>,
        R extends BaseMoneyTransferRepository<E>>
        extends BaseSearchServiceImpl<E, F, S, R>
        implements BaseMoneyTransferSearchService<E, F> {

    protected BaseMoneyTransferSearchServiceImpl(R repository, S spec) {
        super(repository, spec);
    }
}
