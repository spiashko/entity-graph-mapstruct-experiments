package com.siarhei.jpatransactionaldemo.crudbase.service;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EntitySearchService<E extends BaseJournalEntity> {

    Page<E> findAllPage(Pageable pageRequest);

    List<E> findAll();

    Optional<E> findOne(Long id);

    E findOneOrThrow(Long id);

}
