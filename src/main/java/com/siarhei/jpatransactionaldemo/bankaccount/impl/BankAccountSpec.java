package com.siarhei.jpatransactionaldemo.bankaccount.impl;


import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountFilter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class BankAccountSpec extends BaseJournalSpec<BankAccount, BankAccountFilter> {

    @Override
    protected void addSelfPredicatesToList(BankAccountFilter filter, Root<BankAccount> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

}
