package com.siarhei.jpatransactionaldemo.crudbase.spec;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity_;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseJournalSpec<T extends BaseJournalEntity, F extends BaseJournalFilter> extends BaseSpec<T, F> {

    protected void addPredicatesToList(F filter, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

        addIfNotNull(predicates, filter.getCreatedFromInstant(),
                () -> cb.greaterThanOrEqualTo(root.get(BaseJournalEntity_.createdAt), filter.getCreatedFromInstant()));

        addIfNotNull(predicates, filter.getCreatedToInstant(),
                () -> cb.lessThanOrEqualTo(root.get(BaseJournalEntity_.createdAt), filter.getCreatedToInstant()));

        addIfNotNull(predicates, filter.getCreatedBy(),
                () -> root.get(BaseJournalEntity_.createdBy).in(filter.getCreatedBy()));

        addIfNotNull(predicates, filter.getUpdatedFromInstant(),
                () -> cb.greaterThanOrEqualTo(root.get(BaseJournalEntity_.updatedAt), filter.getUpdatedFromInstant()));

        addIfNotNull(predicates, filter.getUpdatedToInstant(),
                () -> cb.lessThanOrEqualTo(root.get(BaseJournalEntity_.updatedAt), filter.getUpdatedToInstant()));

        addIfNotNull(predicates, filter.getUpdatedBy(),
                () -> root.get(BaseJournalEntity_.updatedBy).in(filter.getUpdatedBy()));

        addSelfPredicatesToList(filter, root, query, cb, predicates);
    }

    protected abstract void addSelfPredicatesToList(F filter, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates);

}
