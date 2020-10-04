package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.crudbase.AbstractRetrieveContextResolver;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewC;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewCModel;
import org.springframework.stereotype.Component;

@Component
public class OperationViewCRetrieveContextResolver extends AbstractRetrieveContextResolver<OperationViewC> {

    OperationViewCRetrieveContextResolver(OperationMapper mapper) {
        putInMapping(OperationViewCModel.class, EntityGraphs.named("Operation.viewc"), mapper::mapToViewC);
    }

}
