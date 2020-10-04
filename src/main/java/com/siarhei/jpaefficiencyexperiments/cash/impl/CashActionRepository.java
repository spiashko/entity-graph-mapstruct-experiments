package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import com.siarhei.jpaefficiencyexperiments.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpaefficiencyexperiments.operation.CashOperation;

public interface CashActionRepository extends BaseJournalRepository<CashAction<? extends CashOperation<?>>> {
}
