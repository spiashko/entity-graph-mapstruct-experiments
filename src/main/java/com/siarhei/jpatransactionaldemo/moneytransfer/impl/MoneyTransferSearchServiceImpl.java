package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferSearchService;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferSearchServiceImpl
        extends BaseSearchServiceImpl<MoneyTransfer, MoneyTransferFilter, MoneyTransferModel, MoneyTransferSpec, MoneyTransferRepository, MoneyTransferMapper>
        implements MoneyTransferSearchService {

    public MoneyTransferSearchServiceImpl(MoneyTransferRepository repository, MoneyTransferSpec spec, MoneyTransferMapper mapper) {
        super(repository, spec, mapper);
    }
}
