package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import com.siarhei.jpaefficiencyexperiments.crudbase.repository.BaseJournalRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface BaseCashActionRepository<E extends CashAction<?>> extends BaseJournalRepository<E> {
}
