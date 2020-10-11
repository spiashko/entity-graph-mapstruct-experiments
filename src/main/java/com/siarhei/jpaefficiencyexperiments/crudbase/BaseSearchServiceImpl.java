package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpaefficiencyexperiments.crudbase.exception.EntityNotFoundException;
import com.siarhei.jpaefficiencyexperiments.crudbase.repository.BaseJournalRepository;
import net.jodah.typetools.TypeResolver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class BaseSearchServiceImpl<
        E extends BaseJournalEntity,
        R extends BaseJournalRepository<E>,
        RCR extends RetrieveContextResolver<E>>
        implements BaseSearchService<E> {

    private final RCR resolver;
    private final R repository;
    private final Class<E> persistentClass;

    protected BaseSearchServiceImpl(RCR resolver, R repository) {
        this.resolver = resolver;
        this.repository = repository;

        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(BaseJournalRepository.class, repository.getClass());
        this.persistentClass = (Class<E>) typeArguments[0];
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        RetrieveContext<E, T> retrieveContext = resolver.resolve(clazz);
        Iterable<E> iterable = repository.findAll(retrieveContext.getEntityGraph());
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(e -> retrieveContext.getMapper().apply(e))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<E> findOne(UUID id) {
        return repository.findById(id);
    }

    @Override
    public <T> Optional<T> findOne(UUID id, Class<T> clazz) {
        RetrieveContext<E, T> retrieveContext = resolver.resolve(clazz);
        Optional<E> entity = repository.findById(id, retrieveContext.getEntityGraph());
        return entity.map(e -> retrieveContext.getMapper().apply(e));
    }

    @Override
    public E findOneOrThrow(UUID id) {
        Optional<E> result = findOne(id);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    @Override
    public <T> T findOneOrThrow(UUID id, Class<T> clazz) {
        Optional<T> result = findOne(id, clazz);
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
