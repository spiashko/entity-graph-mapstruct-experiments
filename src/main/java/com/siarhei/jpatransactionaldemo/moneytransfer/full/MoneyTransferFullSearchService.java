package com.siarhei.jpatransactionaldemo.moneytransfer.full;

import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransferSearchService;

public interface MoneyTransferFullSearchService extends BaseMoneyTransferSearchService<MoneyTransferFull, MoneyTransferFullFilter> {
    MoneyTransferFull findMoneyTransferCustom(Long id);
}
