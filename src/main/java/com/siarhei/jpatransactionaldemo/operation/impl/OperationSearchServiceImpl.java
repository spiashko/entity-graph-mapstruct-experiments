package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationModel;
import com.siarhei.jpatransactionaldemo.operation.OperationSearchService;
import org.springframework.stereotype.Service;

@Service
public class OperationSearchServiceImpl
        extends BaseSearchServiceImpl<Operation, OperationFilter, OperationModel, OperationSpec, OperationRepository, OperationMapper>
        implements OperationSearchService {

    protected OperationSearchServiceImpl(OperationRepository repository, OperationSpec spec, OperationMapper mapper) {
        super(repository, spec, mapper);
    }
}
