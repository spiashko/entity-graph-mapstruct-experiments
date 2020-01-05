package com.siarhei.jpatransactionaldemo.crudbase;

import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseSearchService<
        T extends BaseJournalModel,
        F extends BaseJournalFilter> {

    Page<T> findAllPage(Pageable pageRequest);

    Page<T> findAllPage(F filter, Pageable pageRequest);

    List<T> findAll();

    List<T> findAll(F filter);

    Optional<T> findOne(Long id);

    Optional<T> findOne(F filter);

    T findOneOrThrow(Long id);

    T findOneOrThrow(F filter);

}
