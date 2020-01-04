package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BalanceManagementService;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import com.siarhei.jpatransactionaldemo.operation.OutOperation;
import org.springframework.stereotype.Service;

@Service
public class OutOperationManagementServiceImpl
        extends AbstractOperationManagementService<OutOperation, OutOperationRepository>
        implements OperationManagementService<OutOperation> {

    private final BalanceManagementService balanceManagementService;

    public OutOperationManagementServiceImpl(OutOperationRepository repository,
                                             BalanceManagementService balanceManagementService) {
        super(repository);
        this.balanceManagementService = balanceManagementService;
    }

    @Override
    protected void updateBalance(OutOperation operation) {
        balanceManagementService.subtractFromBalance(operation.getBankAccount().getId(), operation.getAmount());
    }
}
