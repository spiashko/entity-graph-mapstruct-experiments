package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpaefficiencyexperiments.crudbase.exception.EntityNotFoundException;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.FromEntityMapper;
import com.siarhei.jpaefficiencyexperiments.crudbase.repository.BaseJournalRepository;
import net.jodah.typetools.TypeResolver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class BaseSearchServiceImpl<
        E extends BaseJournalEntity,
        R extends BaseJournalRepository<E>,
        M extends FromEntityMapper<E>>
        implements BaseSearchService<E> {

    private final M mapper;
    private final R repository;
    private final Class<E> persistentClass;

    protected BaseSearchServiceImpl(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;

        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(BaseJournalRepository.class, repository.getClass());
        this.persistentClass = (Class<E>) typeArguments[0];
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public <T> List<T> findAll(ViewSelector<T> viewSelector) {
        Iterable<E> iterable = viewSelector.getEntityGraph() == null ?
                repository.findAll() :
                repository.findAll(viewSelector.getEntityGraph());
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(e -> mapper.map(e, viewSelector.getClazz()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<E> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public <T> Optional<T> findOne(Long id, ViewSelector<T> viewSelector) {
        Optional<E> entity = viewSelector.getEntityGraph() == null ?
                repository.findById(id) :
                repository.findById(id, viewSelector.getEntityGraph());
        return entity.map(e -> mapper.map(e, viewSelector.getClazz()));
    }

    @Override
    public E findOneOrThrow(Long id) {
        Optional<E> result = findOne(id);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    @Override
    public <T> T findOneOrThrow(Long id, ViewSelector<T> viewSelector) {
        Optional<T> result = findOne(id, viewSelector);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    protected R getRepository() {
        return repository;
    }
}
