package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpaefficiencyexperiments.operation.OperationSummary;
import com.siarhei.jpaefficiencyexperiments.operation.OperationSummarySearchService;
import org.springframework.stereotype.Service;

@Service
public class OperationSummarySearchServiceImpl
        extends BaseSearchServiceImpl<OperationSummary, OperationSummaryRepository, OperationSummaryFromEntityMapper>
        implements OperationSummarySearchService {

    public OperationSummarySearchServiceImpl(
            OperationSummaryRepository repository,
            OperationSummaryFromEntityMapper mapper) {
        super(mapper, repository);
    }

}
