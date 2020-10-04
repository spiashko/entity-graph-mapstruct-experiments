package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseSearchService<E extends BaseJournalEntity> {

    List<E> findAll();

    <T> List<T> findAll(Class<T> clazz);

    Optional<E> findOne(UUID id);

    <T> Optional<T> findOne(UUID id, Class<T> clazz);

    E findOneOrThrow(UUID id);

    <T> T findOneOrThrow(UUID id, Class<T> clazz);

}
