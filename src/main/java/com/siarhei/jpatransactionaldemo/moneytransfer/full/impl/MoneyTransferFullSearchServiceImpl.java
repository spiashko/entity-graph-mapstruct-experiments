package com.siarhei.jpatransactionaldemo.moneytransfer.full.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFullFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFullSearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoneyTransferFullSearchServiceImpl
        extends BaseSearchServiceImpl<MoneyTransferFull, MoneyTransferFullFilter, MoneyTransferFullSpec, MoneyTransferFullRepository>
        implements MoneyTransferFullSearchService {

    protected MoneyTransferFullSearchServiceImpl(MoneyTransferFullRepository repository, MoneyTransferFullSpec spec) {
        super(repository, spec);
    }

    @Transactional
    @Override
    public MoneyTransferFull findMoneyTransferCustom(Long id) {
        MoneyTransferFull moneyTransferFull = findOneOrThrow(id);
        moneyTransferFull.getReceiveOperation();
        return moneyTransferFull;
    }
}
