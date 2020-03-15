package com.siarhei.jpatransactionaldemo.moneytransfer.impl;


import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferFilter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MoneyTransferSpec extends BaseJournalSpec<MoneyTransfer, MoneyTransferFilter> {

    @Override
    protected void addSelfPredicatesToList(MoneyTransferFilter filter, Root<MoneyTransfer> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }
}
