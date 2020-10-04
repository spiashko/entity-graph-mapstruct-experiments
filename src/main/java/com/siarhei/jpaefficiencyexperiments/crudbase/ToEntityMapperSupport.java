package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseEntity;
import com.siarhei.jpaefficiencyexperiments.crudbase.exception.EntityNotFoundException;
import org.mapstruct.Context;
import org.mapstruct.TargetType;

import javax.persistence.EntityManager;
import java.util.UUID;

public interface ToEntityMapperSupport {

    default <T extends BaseEntity> T lookup(UUID id, @Context EntityManager entityManager,
                                            @TargetType Class<T> targetType) {
        T entity = entityManager.find(targetType, id);
        if (entity == null) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with id %s exists!", targetType.getSimpleName(), id));
        }
        return entity;
    }

}
