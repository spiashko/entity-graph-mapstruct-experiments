package com.siarhei.jpatransactionaldemo.crudbase.service;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EntityFilterableSearchService<
        E extends BaseJournalEntity,
        F extends BaseJournalFilter> {

    Page<E> findAllPage(F filter, Pageable pageRequest);

    List<E> findAll(F filter);

    Optional<E> findOne(F filter);

    E findOneOrThrow(F filter);

}
