package com.siarhei.jpatransactionaldemo.moneytransfer.summary.impl;


import com.siarhei.jpatransactionaldemo.moneytransfer.base.impl.BaseMoneyTransferSpec;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummary;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummaryFilter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MoneyTransferSummarySpec extends BaseMoneyTransferSpec<MoneyTransferSummary, MoneyTransferSummaryFilter> {

    @Override
    protected void addMoneyTransferSelfPredicatesToList(MoneyTransferSummaryFilter filter, Root<MoneyTransferSummary> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

}
