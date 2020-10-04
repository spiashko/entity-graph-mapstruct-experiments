package com.siarhei.jpaefficiencyexperiments.crudbase.exception;

import lombok.Getter;

@Getter
public class RequestedClassNotSupportedException extends RuntimeException {

    private final Class<?> requestedClazz;

    public RequestedClassNotSupportedException(Class<?> requestedClazz) {
        this.requestedClazz = requestedClazz;
    }
}
