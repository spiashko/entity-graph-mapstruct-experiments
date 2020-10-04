package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferSearchService;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferSearchServiceImpl
        extends BaseSearchServiceImpl<MoneyTransfer, MoneyTransferRepository, MoneyTransferRetrieveContextResolver>
        implements MoneyTransferSearchService {

    protected MoneyTransferSearchServiceImpl(
            MoneyTransferRepository repository,
            MoneyTransferRetrieveContextResolver resolver) {
        super(resolver, repository);
    }

}
