package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationViewC;
import com.siarhei.jpatransactionaldemo.operation.OperationViewCSearchService;
import org.springframework.stereotype.Service;

@Service
public class OperationViewCSearchServiceImpl
        extends BaseSearchServiceImpl<OperationViewC, OperationFilter, OperationViewCSpec, OperationViewCRepository>
        implements OperationViewCSearchService {

    public OperationViewCSearchServiceImpl(OperationViewCRepository repository, OperationViewCSpec spec) {
        super(repository, spec);
    }

}
