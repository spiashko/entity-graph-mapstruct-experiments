package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.cash.CashAction;
import com.siarhei.jpatransactionaldemo.cash.CashActionCreationModel;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromModelToEntityMapper;
import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.operation.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
abstract class AbstractCashActionManagementService<
        E extends CashAction,
        O extends Operation,
        R extends BaseJournalRepository<E>,
        CM extends CashActionCreationModel,
        M extends BaseFromModelToEntityMapper<E, CM>>
        implements CashActionManagementService<E, CM> {

    private final R repository;
    private final M mapper;
    private final BankAccountSearchService bankAccountSearchService;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //due to updateBalance require REPEATABLE_READ
    @Override
    public E createCashAction(CM createModel) {
        E cashAction = mapper.map(createModel);

        O operation = attachOperation(cashAction);
        operation.setBankAccount(getBankAccount(createModel.getBankAccountId()));
        operation.setAmount(createModel.getCashAmount());

        repository.save(cashAction);
        return cashAction;
    }

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneOrThrow(bankAccountId);
    }

    protected abstract O attachOperation(E cashAction);

}
