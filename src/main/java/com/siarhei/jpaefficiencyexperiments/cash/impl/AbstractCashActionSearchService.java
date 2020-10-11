package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.BaseCashActionSearchService;
import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpaefficiencyexperiments.operation.CashOperation;

abstract class AbstractCashActionSearchService<
        E extends CashAction<? extends CashOperation<E>>,
        R extends BaseCashActionRepository<E>,
        RCR extends AbstractCashActionRetrieveContextResolver<E>>
        extends BaseSearchServiceImpl<E, R, RCR>
        implements BaseCashActionSearchService<E> {

    protected AbstractCashActionSearchService(RCR resolver, R repository) {
        super(resolver, repository);
    }

}
