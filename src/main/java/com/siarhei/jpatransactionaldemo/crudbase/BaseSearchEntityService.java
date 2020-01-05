package com.siarhei.jpatransactionaldemo.crudbase;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseSearchEntityService<
        E extends BaseJournalEntity,
        F extends BaseJournalFilter> {

    Page<E> findAllEntitiesPage(Pageable pageRequest);

    Page<E> findAllEntitiesPage(F filter, Pageable pageRequest);

    List<E> findAllEntities();

    List<E> findAllEntities(F filter);

    Optional<E> findOneEntity(Long id);

    Optional<E> findOneEntity(F filter);

    E findOneEntityOrThrow(Long id);

    E findOneEntityOrThrow(F filter);

}
