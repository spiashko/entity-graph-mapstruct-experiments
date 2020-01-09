package com.siarhei.jpatransactionaldemo.moneytransfer.base.impl;


import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransferFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseMoneyTransferSpec<E extends BaseMoneyTransfer, F extends BaseMoneyTransferFilter> extends BaseJournalSpec<E, F> {

    @Override
    protected void addSelfPredicatesToList(F filter, Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

    protected abstract void addMoneyTransferSelfPredicatesToList(F filter, Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates);

}
