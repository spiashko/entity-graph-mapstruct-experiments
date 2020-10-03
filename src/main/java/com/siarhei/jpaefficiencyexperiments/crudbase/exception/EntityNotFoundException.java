package com.siarhei.jpaefficiencyexperiments.crudbase.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String error) {
        super(error);
    }
}
