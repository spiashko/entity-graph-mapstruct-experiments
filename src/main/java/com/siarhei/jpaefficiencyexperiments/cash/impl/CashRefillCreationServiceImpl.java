package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationService;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class CashRefillCreationServiceImpl
        extends AbstractCashActionCreationService<CashRefill, CashRefillViewBModel, CashRefillCreationModel>
        implements CashRefillCreationService {

    public CashRefillCreationServiceImpl(
            EntityManager entityManager,
            CashRefillCreationMapper mapper,
            CashRefillSearchMapper searchMapper,
            CashActionRepository cashActionRepository) {
        super(cm -> mapper.map(cm, entityManager), searchMapper::mapToViewB, cashActionRepository);
    }

}
