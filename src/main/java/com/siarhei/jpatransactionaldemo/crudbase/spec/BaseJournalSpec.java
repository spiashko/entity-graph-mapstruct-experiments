package com.siarhei.jpatransactionaldemo.crudbase.spec;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseJournalSpec<T extends BaseJournalEntity, F extends BaseJournalFilter> extends BaseSpec<T, F> {

    protected void addPredicatesToList(F filter, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

        addIfNotNull(predicates, filter.getCreatedFromInstant(),
                () -> cb.greaterThanOrEqualTo(root.get("createdAt"), filter.getCreatedFromInstant()));

        addIfNotNull(predicates, filter.getCreatedToInstant(),
                () -> cb.lessThanOrEqualTo(root.get("createdAt"), filter.getCreatedToInstant()));

        addIfNotNull(predicates, filter.getCreatedBy(),
                () -> root.get("createdBy").in(filter.getCreatedBy()));

        addIfNotNull(predicates, filter.getUpdatedFromInstant(),
                () -> cb.greaterThanOrEqualTo(root.get("updatedAt"), filter.getUpdatedFromInstant()));

        addIfNotNull(predicates, filter.getUpdatedToInstant(),
                () -> cb.lessThanOrEqualTo(root.get("updatedAt"), filter.getUpdatedToInstant()));

        addIfNotNull(predicates, filter.getUpdatedBy(),
                () -> root.get("updatedBy").in(filter.getUpdatedBy()));

        addSelfPredicatesToList(filter, root, query, cb, predicates);
    }

    protected abstract void addSelfPredicatesToList(F filter, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates);

}
