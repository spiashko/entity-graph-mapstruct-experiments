package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.crudbase.AbstractRetrieveContextResolver;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewAModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import org.springframework.stereotype.Component;

@Component
public class MoneyTransferRetrieveContextResolver extends AbstractRetrieveContextResolver<MoneyTransfer> {

    MoneyTransferRetrieveContextResolver(MoneyTransferMapper mapper) {
        putInMapping(MoneyTransferViewAModel.class, null, mapper::mapToViewA);
        putInMapping(MoneyTransferViewBModel.class, EntityGraphs.named("MoneyTransfer.all"), mapper::mapToViewB);
    }

}
