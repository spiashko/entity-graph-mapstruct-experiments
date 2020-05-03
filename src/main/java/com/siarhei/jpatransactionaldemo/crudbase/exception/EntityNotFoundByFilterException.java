package com.siarhei.jpatransactionaldemo.crudbase.exception;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseEntity;
import com.siarhei.jpatransactionaldemo.crudbase.filter.BaseFilter;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@ToString
public class EntityNotFoundByFilterException extends EntityNotFoundException {

    private final BaseFilter filter;

    public EntityNotFoundByFilterException(Class<? extends BaseEntity> persistentClass, BaseFilter filter) {
        super(String.format("entity %s according to filter %s does not exists!", persistentClass.getSimpleName(), filter),
                persistentClass);
        this.filter = filter;
    }
}
