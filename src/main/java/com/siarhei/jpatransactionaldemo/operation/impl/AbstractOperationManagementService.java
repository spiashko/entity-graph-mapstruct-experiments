package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.operation.Operation;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
abstract class AbstractOperationManagementService<T extends Operation, R extends BaseJournalRepository<T>> implements OperationManagementService<T> {

    private final R repository;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //due to updateBalance require REPEATABLE_READ
    @Override
    public T createOperation(T operation) {

        if (operation.getId() != null) {
            throw new IllegalArgumentException("id must be null");
        }

        repository.save(operation);
        updateBalance(operation);

        return operation;
    }

    protected abstract void updateBalance(T operation);

}
