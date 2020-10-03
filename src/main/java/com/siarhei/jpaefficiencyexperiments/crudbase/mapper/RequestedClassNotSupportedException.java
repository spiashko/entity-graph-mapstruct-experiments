package com.siarhei.jpaefficiencyexperiments.crudbase.mapper;

import lombok.Getter;

@Getter
public class RequestedClassNotSupportedException extends RuntimeException {

    private final Class<?> requestedClazz;

    public RequestedClassNotSupportedException(Class<?> requestedClazz) {
        this.requestedClazz = requestedClazz;
    }
}
