package com.siarhei.jpatransactionaldemo.operation.impl;


import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import com.siarhei.jpatransactionaldemo.operation.Operation;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class OperationSpec extends BaseJournalSpec<Operation, OperationFilter> {

    @Override
    protected void addSelfPredicatesToList(OperationFilter filter, Root<Operation> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }

}
