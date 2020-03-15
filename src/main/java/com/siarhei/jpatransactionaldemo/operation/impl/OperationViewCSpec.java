package com.siarhei.jpatransactionaldemo.operation.impl;


import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationViewC;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class OperationViewCSpec extends BaseJournalSpec<OperationViewC, OperationFilter> {

    @Override
    protected void addSelfPredicatesToList(OperationFilter filter, Root<OperationViewC> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

}
