package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.crudbase.AbstractRetrieveContextResolver;
import com.siarhei.jpaefficiencyexperiments.operation.OperationSummary;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewAModel;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewBModel;
import org.springframework.stereotype.Component;

@Component
public class OperationSummaryRetrieveContextResolver extends AbstractRetrieveContextResolver<OperationSummary> {

    OperationSummaryRetrieveContextResolver(OperationMapper mapper) {
        putInMapping(OperationViewAModel.class, null, mapper::mapToViewA);
        putInMapping(OperationViewBModel.class, EntityGraphs.named("Operation.viewb"), mapper::mapToViewB);
    }

}
