package com.siarhei.jpatransactionaldemo.cash.impl;


import com.siarhei.jpatransactionaldemo.cash.CashActionFilter;
import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class CashActionSpec extends BaseJournalSpec<CashAction, CashActionFilter> {

    @Override
    protected void addSelfPredicatesToList(CashActionFilter filter, Root<CashAction> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

}
