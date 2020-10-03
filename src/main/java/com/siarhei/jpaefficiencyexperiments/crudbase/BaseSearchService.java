package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;

import java.util.List;
import java.util.Optional;

public interface BaseSearchService<E extends BaseJournalEntity> {

    List<E> findAll();

    <T> List<T> findAll(ViewSelector<T> viewSelector);

    Optional<E> findOne(Long id);

    <T> Optional<T> findOne(Long id, ViewSelector<T> viewSelector);

    E findOneOrThrow(Long id);

    <T> T findOneOrThrow(Long id, ViewSelector<T> viewSelector);

}
