package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountFilter;
import com.siarhei.jpatransactionaldemo.bankaccount.service.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BankAccountSearchServiceImpl
        extends BaseSearchServiceImpl<BankAccount, BankAccountFilter, BankAccountSpec, BankAccountRepository>
        implements BankAccountSearchService {

    public BankAccountSearchServiceImpl(BankAccountRepository repository, BankAccountSpec spec) {
        super(repository, spec);
    }
}
