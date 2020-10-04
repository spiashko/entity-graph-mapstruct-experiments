package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashActionCreationService;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewBModel;
import org.springframework.stereotype.Service;

@Service
public class CashWithdrawalCreationServiceImpl
        extends AbstractCashActionCreationService<CashWithdrawal, CashWithdrawalViewBModel, CashWithdrawalCreationModel>
        implements CashActionCreationService<CashWithdrawalViewBModel, CashWithdrawalCreationModel> {

    public CashWithdrawalCreationServiceImpl(
            CashWithdrawalMapper mapper,
            CashActionRepository cashActionRepository) {
        super(mapper::map, mapper::mapToViewB, cashActionRepository);
    }
}
