package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccountSearchEntityService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashActionModel;
import com.siarhei.jpatransactionaldemo.cash.CreateCashActionModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseEntityModelMapper;
import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.operation.impl.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
abstract class AbstractCashActionManagementService<
        T extends CashAction,
        O extends Operation,
        R extends BaseJournalRepository<T>,
        RM extends CashActionModel,
        CM extends CreateCashActionModel,
        M extends BaseEntityModelMapper<T, RM, CM>>
        implements CashActionManagementService<RM, CM> {

    private final R repository;
    private final M mapper;
    private final BankAccountSearchEntityService bankAccountSearchService;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //due to updateBalance require REPEATABLE_READ
    @Override
    public RM createCashAction(CM createModel) {
        T cashAction = mapper.map(createModel);

        O operation = attachOperation(cashAction);
        operation.setBankAccount(getBankAccount(createModel.getBankAccountId()));
        operation.setAmount(createModel.getCashAmount());

        repository.save(cashAction);
        return mapper.map(cashAction);
    }

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneEntityOrThrow(bankAccountId);
    }

    protected abstract O attachOperation(T cashAction);

}
