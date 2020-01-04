package com.siarhei.jpatransactionaldemo.operation;

public interface OperationManagementService<T extends Operation> {

    T createOperation(T operation);

}
