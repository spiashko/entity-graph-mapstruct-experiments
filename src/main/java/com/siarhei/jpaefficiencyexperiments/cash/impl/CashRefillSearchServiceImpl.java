package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillSearchService;
import org.springframework.stereotype.Service;

@Service
class CashRefillSearchServiceImpl
        extends AbstractCashActionSearchService<CashRefill, CashRefillRepository, CashRefillRetrieveContextResolver>
        implements CashRefillSearchService {

    public CashRefillSearchServiceImpl(
            CashRefillRepository repository,
            CashRefillRetrieveContextResolver resolver) {
        super(resolver, repository);
    }
}
