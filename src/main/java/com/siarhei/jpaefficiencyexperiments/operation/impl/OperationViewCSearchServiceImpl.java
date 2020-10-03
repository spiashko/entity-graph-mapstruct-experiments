package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewC;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewCSearchService;
import org.springframework.stereotype.Service;

@Service
public class OperationViewCSearchServiceImpl
        extends BaseSearchServiceImpl<OperationViewC, OperationViewCRepository, OperationViewCFromEntityMapper>
        implements OperationViewCSearchService {

    public OperationViewCSearchServiceImpl(
            OperationViewCRepository repository,
            OperationViewCFromEntityMapper mapper) {
        super(mapper, repository);
    }

}
