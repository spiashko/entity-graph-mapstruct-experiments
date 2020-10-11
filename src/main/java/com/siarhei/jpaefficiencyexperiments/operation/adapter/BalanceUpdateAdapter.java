package com.siarhei.jpaefficiencyexperiments.operation.adapter;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BalanceManagementService;
import com.siarhei.jpaefficiencyexperiments.operation.InOperation;
import com.siarhei.jpaefficiencyexperiments.operation.Operation;
import com.siarhei.jpaefficiencyexperiments.operation.OutOperation;
import com.siarhei.jpaefficiencyexperiments.operation.event.OperationPreparedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Service
class BalanceUpdateAdapter {

    private final BalanceManagementService balanceManagementService;

    @EventListener(OperationPreparedEvent.class)
    @Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.REPEATABLE_READ)
    @Validated
    public void updateBalance(OperationPreparedEvent event) {
        Operation operation = event.getOperation();
        if (!operation.isNew()) {
            throw new RuntimeException("operation must be new");
        }

        if (operation instanceof InOperation) {
            balanceManagementService.addToBalance(operation.getBankAccount().getId(), operation.getAmount());
        } else if (operation instanceof OutOperation) {
            balanceManagementService.subtractFromBalance(operation.getBankAccount().getId(), operation.getAmount());
        } else {
            throw new RuntimeException("unknown operation type");
        }

    }

}
