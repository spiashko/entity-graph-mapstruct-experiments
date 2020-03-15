package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationSummary;
import com.siarhei.jpatransactionaldemo.operation.OperationSummarySearchService;
import org.springframework.stereotype.Service;

@Service
public class OperationSummarySearchServiceImpl
        extends BaseSearchServiceImpl<OperationSummary, OperationFilter, OperationSummarySpec, OperationSummaryRepository>
        implements OperationSummarySearchService {

    public OperationSummarySearchServiceImpl(OperationSummaryRepository repository, OperationSummarySpec spec) {
        super(repository, spec);
    }

}
