package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewBModel;
import org.springframework.stereotype.Component;

@Component
class CashWithdrawalRetrieveContextResolver extends AbstractCashActionRetrieveContextResolver<CashWithdrawal> {

    CashWithdrawalRetrieveContextResolver(CashWithdrawalSearchMapper mapper) {
        putInMapping(CashWithdrawalViewAModel.class, EntityGraphs.empty(), mapper::mapToViewA);
        putInMapping(CashWithdrawalViewBModel.class, EntityGraphs.named("CashWithdrawal.operation"), mapper::mapToViewB);
    }
}
