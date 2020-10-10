package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import org.springframework.stereotype.Component;

@Component
class CashRefillRetrieveContextResolver extends AbstractCashActionRetrieveContextResolver<CashRefill> {

    CashRefillRetrieveContextResolver(CashRefillSearchMapper mapper) {
        putInMapping(CashRefillViewAModel.class, EntityGraphs.empty(), mapper::mapToViewA);
        putInMapping(CashRefillViewBModel.class, EntityGraphs.named("CashRefill.operation"), mapper::mapToViewB);
    }
}
