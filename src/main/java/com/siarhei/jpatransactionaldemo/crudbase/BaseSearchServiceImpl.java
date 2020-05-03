package com.siarhei.jpatransactionaldemo.crudbase;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.exception.EntityNotFoundByFilterException;
import com.siarhei.jpatransactionaldemo.crudbase.exception.EntityNotFoundByIdException;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import net.jodah.typetools.TypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public abstract class BaseSearchServiceImpl<
        E extends BaseJournalEntity,
        F extends BaseJournalFilter,
        S extends BaseJournalSpec<E, F>,
        R extends BaseJournalRepository<E>>
        implements BaseSearchService<E, F> {

    private final R repository;
    private final S spec;

    private final Class<E> persistentClass;

    protected BaseSearchServiceImpl(R repository, S spec) {
        this.repository = repository;
        this.spec = spec;

        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(BaseJournalRepository.class, repository.getClass());
        this.persistentClass = (Class<E>) typeArguments[0];
    }

    @Override
    public Page<E> findAllPage(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public Page<E> findAllPage(F filter, Pageable pageRequest) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification, pageRequest);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAll(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification);
    }

    @Override
    public Optional<E> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<E> findOne(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findOne(specification);
    }

    @Override
    public E findOneOrThrow(Long id) {
        Optional<E> result = findOne(id);
        if (!result.isPresent()) {
            throw new EntityNotFoundByIdException(persistentClass, id);
        }
        return result.get();
    }

    @Override
    public E findOneOrThrow(F filter) {
        Optional<E> result = findOne(filter);
        if (!result.isPresent()) {
            throw new EntityNotFoundByFilterException(persistentClass, filter);
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
