package com.siarhei.jpatransactionaldemo.bankaccount.service;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountFilter;
import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchService;

public interface BankAccountSearchService extends BaseSearchService<BankAccount, BankAccountFilter> {
}
