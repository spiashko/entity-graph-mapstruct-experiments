package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;

import java.util.List;
import java.util.Optional;

public interface BaseSearchService<E extends BaseJournalEntity> {

    List<E> findAll();

    <T> List<T> findAll(Class<T> clazz);

    Optional<E> findOne(Long id);

    <T> Optional<T> findOne(Long id, Class<T> clazz);

    E findOneOrThrow(Long id);

    <T> T findOneOrThrow(Long id, Class<T> clazz);

}
