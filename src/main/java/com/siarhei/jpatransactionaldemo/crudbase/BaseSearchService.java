package com.siarhei.jpatransactionaldemo.crudbase;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
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

    Page<E> findAllPage(Pageable pageRequest, EntityGraph entityGraph);

    Page<E> findAllPage(F filter, Pageable pageRequest);

    Page<E> findAllPage(F filter, Pageable pageRequest, EntityGraph entityGraph);

    List<E> findAll();

    Iterable<E> findAll(EntityGraph entityGraph);

    List<E> findAll(F filter);

    Iterable<E> findAll(F filter, EntityGraph entityGraph);

    Optional<E> findOne(Long id);

    Optional<E> findOne(Long id, EntityGraph entityGraph);

    Optional<E> findOne(F filter);

    Optional<E> findOne(F filter, EntityGraph entityGraph);

    E findOneOrThrow(Long id);

    E findOneOrThrow(Long id, EntityGraph entityGraph);

    E findOneOrThrow(F filter);

    E findOneOrThrow(F filter, EntityGraph entityGraph);

}
