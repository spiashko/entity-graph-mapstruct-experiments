package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashActionFilter;
import com.siarhei.jpatransactionaldemo.cash.CashActionModel;
import com.siarhei.jpatransactionaldemo.cash.CashActionSearchService;
import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CashActionSearchServiceImpl
        extends BaseSearchServiceImpl<CashAction, CashActionFilter, CashActionModel, CashActionSpec, CashActionRepository, CashActionMapper>
        implements CashActionSearchService {

    public CashActionSearchServiceImpl(CashActionRepository repository, CashActionSpec spec, CashActionMapper mapper) {
        super(repository, spec, mapper);
    }
}
