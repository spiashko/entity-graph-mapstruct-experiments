package com.siarhei.jpatransactionaldemo.crudbase;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseSearchService<
        E extends BaseJournalEntity,
        F extends BaseJournalFilter> {

    Page<E> findAllPage(Pageable pageRequest);

    Page<E> findAllPage(F filter, Pageable pageRequest);

    List<E> findAll();

    List<E> findAll(F filter);

    Optional<E> findOne(Long id);

    Optional<E> findOne(F filter);

    E findOneOrThrow(Long id);

    E findOneOrThrow(F filter);

}
