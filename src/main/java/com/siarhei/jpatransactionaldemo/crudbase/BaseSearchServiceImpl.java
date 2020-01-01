package com.siarhei.jpatransactionaldemo.crudbase;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.exception.ResultsNotFoundException;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class BaseSearchServiceImpl<
        E extends BaseJournalEntity,
        F extends BaseJournalFilter,
        S extends BaseJournalSpec<E, F>,
        R extends BaseJournalRepository<E>> implements BaseSearchService<E, F> {

    private final R repository;
    private final S spec;

    private Class<E> persistentClass;

    protected BaseSearchServiceImpl(R repository, S spec) {
        this.repository = repository;
        this.spec = spec;

        this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Page<E> findAllPage(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }

    public Page<E> findAllPage(F filter, Pageable pageRequest) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification, pageRequest);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public List<E> findAll(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification);
    }

    public Optional<E> findOne(Long id) {
        return repository.findById(id);
    }

    public Optional<E> findOne(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findOne(specification);
    }

    public E findOneOrThrow(Long id) {
        Optional<E> result = findOne(id);
        if (!result.isPresent()) {
            throw new ResultsNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    public E findOneOrThrow(F filter) {
        Optional<E> result = findOne(filter);
        if (!result.isPresent()) {
            throw new ResultsNotFoundException(
                    String.format("resource %s not found by filter=%s", persistentClass.getSimpleName(), filter));
        }
        return result.get();
    }

    protected R getRepository() {
        return repository;
    }

    protected S getSpec() {
        return spec;
    }

}
