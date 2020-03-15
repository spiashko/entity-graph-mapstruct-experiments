package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchService;

public interface MoneyTransferSearchService extends BaseSearchService<MoneyTransfer, MoneyTransferFilter> {
    MoneyTransfer findMoneyTransferCustom(Long id);
}
