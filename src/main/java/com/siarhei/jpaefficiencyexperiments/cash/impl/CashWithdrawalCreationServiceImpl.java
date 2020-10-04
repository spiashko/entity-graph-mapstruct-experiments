package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashActionCreationService;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewBModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class CashWithdrawalCreationServiceImpl
        extends AbstractCashActionCreationService<CashWithdrawal, CashWithdrawalViewBModel, CashWithdrawalCreationModel>
        implements CashActionCreationService<CashWithdrawalViewBModel, CashWithdrawalCreationModel> {

    private static final Long DEFAULT_FEE = 1L;

    public CashWithdrawalCreationServiceImpl(
            EntityManager entityManager,
            CashWithdrawalCreationMapper mapper,
            CashWithdrawalSearchMapper searchMapper,
            CashActionRepository cashActionRepository) {
        super(cm -> mapper.map(cm, DEFAULT_FEE, entityManager), searchMapper::mapToViewB, cashActionRepository);
    }
}
