package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.service.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.cash.CashAction;
import com.siarhei.jpatransactionaldemo.cash.CashActionCreationModel;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromModelToEntityMapper;
import com.siarhei.jpatransactionaldemo.operation.Operation;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@RequiredArgsConstructor
abstract class AbstractCashActionManagementService<
        E extends CashAction,
        O extends Operation,
        CM extends CashActionCreationModel,
        M extends BaseFromModelToEntityMapper<E, CM>>
        implements CashActionManagementService<E, CM> {

    private final M mapper;
    private final BankAccountSearchService bankAccountSearchService;
    protected final OperationManagementService operationManagementService;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //due to updateBalance require REPEATABLE_READ
    @Override
    public E createCashAction(CM createModel) {
        E cashAction = mapper.map(createModel);

        O operation = instantiateOperationEntity(cashAction);

        operation.setBankAccount(getBankAccount(createModel.getBankAccountId()));
        operation.setAmount(createModel.getCashAmount());

        operationSaveMethod().accept(operation);

        return cashAction;
    }

    protected abstract Consumer<O> operationSaveMethod();

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneOrThrow(bankAccountId);
    }

    protected abstract O instantiateOperationEntity(E cashAction);

}
