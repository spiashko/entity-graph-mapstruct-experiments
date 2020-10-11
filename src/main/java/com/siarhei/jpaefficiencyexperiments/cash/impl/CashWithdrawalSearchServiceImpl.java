package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalSearchService;
import org.springframework.stereotype.Service;

@Service
class CashWithdrawalSearchServiceImpl
        extends AbstractCashActionSearchService<CashWithdrawal, CashWithdrawalRepository, CashWithdrawalRetrieveContextResolver>
        implements CashWithdrawalSearchService {

    public CashWithdrawalSearchServiceImpl(
            CashWithdrawalRepository repository,
            CashWithdrawalRetrieveContextResolver resolver) {
        super(resolver, repository);
    }
}
