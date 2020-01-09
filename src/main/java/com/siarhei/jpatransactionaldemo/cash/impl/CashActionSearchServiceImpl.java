package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashAction;
import com.siarhei.jpatransactionaldemo.cash.CashActionFilter;
import com.siarhei.jpatransactionaldemo.cash.CashActionSearchService;
import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CashActionSearchServiceImpl
        extends BaseSearchServiceImpl<CashAction, CashActionFilter, CashActionSpec, CashActionRepository>
        implements CashActionSearchService {

    public CashActionSearchServiceImpl(CashActionRepository repository, CashActionSpec spec) {
        super(repository, spec);
    }
}
