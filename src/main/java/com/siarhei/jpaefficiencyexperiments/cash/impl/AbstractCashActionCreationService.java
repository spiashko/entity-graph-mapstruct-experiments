package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.BaseCashActionCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.BaseCashActionViewBModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import com.siarhei.jpaefficiencyexperiments.cash.CashActionCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@RequiredArgsConstructor
abstract class AbstractCashActionCreationService<
        E extends CashAction,
        RM extends BaseCashActionViewBModel,
        CM extends BaseCashActionCreationModel>
        implements CashActionCreationService<RM, CM> {

    private final Function<CM, E> mapperToEntity;
    private final Function<E, RM> mapperFromEntity;
    private final CashActionRepository cashActionRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //due to updateBalance require REPEATABLE_READ
    @Override
    public RM createCashAction(CM createModel) {
        E cashAction = mapperToEntity.apply(createModel);
        cashActionRepository.save(cashAction);
        return mapperFromEntity.apply(cashAction);
    }

}
