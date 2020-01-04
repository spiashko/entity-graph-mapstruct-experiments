package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.operation.Operation;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationSearchService;
import org.springframework.stereotype.Service;

@Service
public class OperationSearchServiceImpl
        extends BaseSearchServiceImpl<Operation, OperationFilter, OperationSpec, OperationRepository>
        implements OperationSearchService {


    protected OperationSearchServiceImpl(OperationRepository repository, OperationSpec spec) {
        super(repository, spec);
    }
}
