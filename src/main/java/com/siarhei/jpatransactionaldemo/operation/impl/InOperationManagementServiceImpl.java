package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BalanceManagementService;
import com.siarhei.jpatransactionaldemo.operation.InOperation;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import org.springframework.stereotype.Service;

@Service
public class InOperationManagementServiceImpl
        extends AbstractOperationManagementService<InOperation, InOperationRepository>
        implements OperationManagementService<InOperation> {

    private final BalanceManagementService balanceManagementService;

    public InOperationManagementServiceImpl(InOperationRepository repository, BalanceManagementService balanceManagementService) {
        super(repository);
        this.balanceManagementService = balanceManagementService;
    }

    @Override
    protected void updateBalance(InOperation operation) {
        balanceManagementService.addToBalance(operation.getBankAccount().getId(), operation.getAmount());
    }
}
