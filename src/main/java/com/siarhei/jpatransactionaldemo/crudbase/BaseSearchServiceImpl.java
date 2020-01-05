package com.siarhei.jpatransactionaldemo.crudbase;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.exception.ResultsNotFoundException;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseJournalFilter;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromEntityToModelMapper;
import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;
import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.crudbase.spec.BaseJournalSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseSearchServiceImpl<
        E extends BaseJournalEntity,
        F extends BaseJournalFilter,
        T extends BaseJournalModel,
        S extends BaseJournalSpec<E, F>,
        R extends BaseJournalRepository<E>,
        M extends BaseFromEntityToModelMapper<E, T>>
        implements BaseSearchService<T, F>, BaseSearchEntityService<E, F> {

    private final R repository;
    private final S spec;
    private final M mapper;

    private Class<E> persistentClass;

    protected BaseSearchServiceImpl(R repository, S spec, M mapper) {
        this.repository = repository;
        this.spec = spec;
        this.mapper = mapper;

        this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    ////////////BaseSearchInternalService/////////

    public Page<E> findAllEntitiesPage(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }

    public Page<E> findAllEntitiesPage(F filter, Pageable pageRequest) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification, pageRequest);
    }

    public List<E> findAllEntities() {
        return repository.findAll();
    }

    public List<E> findAllEntities(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification);
    }

    public Optional<E> findOneEntity(Long id) {
        return repository.findById(id);
    }

    public Optional<E> findOneEntity(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findOne(specification);
    }

    public E findOneEntityOrThrow(Long id) {
        Optional<E> result = findOneEntity(id);
        if (!result.isPresent()) {
            throw new ResultsNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    public E findOneEntityOrThrow(F filter) {
        Optional<E> result = findOneEntity(filter);
        if (!result.isPresent()) {
            throw new ResultsNotFoundException(
                    String.format("resource %s not found by filter=%s", persistentClass.getSimpleName(), filter));
        }
        return result.get();
    }

    ////////////BaseSearchService/////////////

    public Page<T> findAllPage(Pageable pageRequest) {
        return convertPage(findAllEntitiesPage(pageRequest));
    }

    public Page<T> findAllPage(F filter, Pageable pageRequest) {
        return convertPage(findAllEntitiesPage(filter, pageRequest));
    }

    public List<T> findAll() {
        return convertList(findAllEntities());
    }

    public List<T> findAll(F filter) {
        return convertList(findAllEntities(filter));
    }

    public Optional<T> findOne(Long id) {
        return convertOptionalEntity(findOneEntity(id));
    }

    public Optional<T> findOne(F filter) {
        return convertOptionalEntity(findOneEntity(filter));
    }

    public T findOneOrThrow(Long id) {
        return convertEntity(findOneEntityOrThrow(id));
    }

    public T findOneOrThrow(F filter) {
        return convertEntity(findOneEntityOrThrow(filter));
    }

    private T convertEntity(E entity) {
        return mapper.map(entity);
    }

    private Optional<T> convertOptionalEntity(Optional<E> entity) {
        return entity.map(this::convertEntity);
    }

    private List<T> convertList(List<E> entities) {
        return entities.stream().map(this::convertEntity).collect(Collectors.toList());
    }

    private Page<T> convertPage(Page<E> page) {
        return page.map(this::convertEntity);
    }

    ////Getters/////

    protected R getRepository() {
        return repository;
    }

    protected S getSpec() {
        return spec;
    }

    protected M getMapper() {
        return mapper;
    }
}
