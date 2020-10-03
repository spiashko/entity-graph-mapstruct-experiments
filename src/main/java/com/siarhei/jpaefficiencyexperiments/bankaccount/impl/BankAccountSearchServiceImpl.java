package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountSearchService;
import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BankAccountSearchServiceImpl
        extends BaseSearchServiceImpl<BankAccount, BankAccountRepository, BankAccountFromEntityMapper>
        implements BankAccountSearchService {

    public BankAccountSearchServiceImpl(
            BankAccountRepository repository,
            BankAccountFromEntityMapper mapper) {
        super(mapper, repository);
    }
}
