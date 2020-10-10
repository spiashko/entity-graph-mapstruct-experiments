package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import com.siarhei.jpaefficiencyexperiments.crudbase.AbstractRetrieveContextResolver;
import com.siarhei.jpaefficiencyexperiments.operation.CashOperation;

abstract class AbstractCashActionRetrieveContextResolver<E extends CashAction<? extends CashOperation<E>>>
        extends AbstractRetrieveContextResolver<E> {

}
