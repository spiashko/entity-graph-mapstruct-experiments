package com.siarhei.jpatransactionaldemo.moneytransfer.full.impl;


import com.siarhei.jpatransactionaldemo.moneytransfer.base.impl.BaseMoneyTransferSpec;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFullFilter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MoneyTransferFullSpec extends BaseMoneyTransferSpec<MoneyTransferFull, MoneyTransferFullFilter> {

    @Override
    protected void addMoneyTransferSelfPredicatesToList(MoneyTransferFullFilter filter, Root<MoneyTransferFull> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

}
