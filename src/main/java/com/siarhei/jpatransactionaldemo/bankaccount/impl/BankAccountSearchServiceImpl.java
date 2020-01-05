package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountFilter;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountModel;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BankAccountSearchServiceImpl
        extends BaseSearchServiceImpl<BankAccount, BankAccountFilter, BankAccountModel, BankAccountSpec, BankAccountRepository, BankAccountMapper>
        implements BankAccountSearchService, BankAccountSearchEntityService {

    protected BankAccountSearchServiceImpl(BankAccountRepository repository, BankAccountSpec spec, BankAccountMapper mapper) {
        super(repository, spec, mapper);
    }
}
