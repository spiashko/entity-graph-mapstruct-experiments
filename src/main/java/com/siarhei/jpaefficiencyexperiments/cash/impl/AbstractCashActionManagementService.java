package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import com.siarhei.jpaefficiencyexperiments.cash.CashActionCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashActionManagementService;
import com.siarhei.jpaefficiencyexperiments.operation.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@RequiredArgsConstructor
abstract class AbstractCashActionManagementService<
        E extends CashAction,
        O extends Operation,
        CM extends CashActionCreationModel,
        M extends Function<CM, E>>
        implements CashActionManagementService<E, CM> {

    private final M mapper;
    private final CashActionRepository cashActionRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //due to updateBalance require REPEATABLE_READ
    @Override
    public E createCashAction(CM createModel) {
        E cashAction = mapper.apply(createModel);
        cashActionRepository.save(cashAction);
        return cashAction;
    }

}
