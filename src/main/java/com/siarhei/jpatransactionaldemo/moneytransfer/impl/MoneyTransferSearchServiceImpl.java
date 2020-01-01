package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferSearchService;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferSearchServiceImpl
        extends BaseSearchServiceImpl<MoneyTransfer, MoneyTransferFilter, MoneyTransferSpec, MoneyTransferRepository>
        implements MoneyTransferSearchService {


    protected MoneyTransferSearchServiceImpl(MoneyTransferRepository repository, MoneyTransferSpec spec) {
        super(repository, spec);
    }
}
