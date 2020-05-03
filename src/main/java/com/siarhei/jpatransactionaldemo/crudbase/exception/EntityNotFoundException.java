package com.siarhei.jpatransactionaldemo.crudbase.exception;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class EntityNotFoundException extends RuntimeException {

    private final Class<? extends BaseEntity> persistentClass;

    public EntityNotFoundException(String message, Class<? extends BaseEntity> persistentClass) {
        super(message);
        this.persistentClass = persistentClass;
    }

    public EntityNotFoundException(String message, Throwable cause, Class<? extends BaseEntity> persistentClass) {
        super(message, cause);
        this.persistentClass = persistentClass;
    }
}
