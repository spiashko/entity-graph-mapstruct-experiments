package com.siarhei.jpatransactionaldemo.crudbase.exception;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseEntity;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@ToString
public class EntityNotFoundByIdException extends EntityNotFoundException {

    private final Long id;

    public EntityNotFoundByIdException(Class<? extends BaseEntity> persistentClass, Long id) {
        super(String.format("entity %s with id %s does not exists!", persistentClass.getSimpleName(), id),
                persistentClass);
        this.id = id;
    }
}
