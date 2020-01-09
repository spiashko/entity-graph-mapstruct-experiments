package com.siarhei.jpatransactionaldemo.moneytransfer.summary.impl;

import com.siarhei.jpatransactionaldemo.moneytransfer.base.impl.BaseMoneyTransferSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummary;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummaryFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummarySearchService;
import org.springframework.stereotype.Component;

@Component
public class MoneyTransferSummarySearchServiceImpl
        extends BaseMoneyTransferSearchServiceImpl<MoneyTransferSummary, MoneyTransferSummaryFilter, MoneyTransferSummarySpec, MoneyTransferSummaryRepository>
        implements MoneyTransferSummarySearchService {

    protected MoneyTransferSummarySearchServiceImpl(MoneyTransferSummaryRepository repository, MoneyTransferSummarySpec spec) {
        super(repository, spec);
    }
}
