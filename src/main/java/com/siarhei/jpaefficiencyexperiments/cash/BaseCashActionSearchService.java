package com.siarhei.jpaefficiencyexperiments.cash;

import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchService;
import com.siarhei.jpaefficiencyexperiments.operation.CashOperation;

public interface BaseCashActionSearchService<E extends CashAction<? extends CashOperation<E>>> extends BaseSearchService<E> {
}
