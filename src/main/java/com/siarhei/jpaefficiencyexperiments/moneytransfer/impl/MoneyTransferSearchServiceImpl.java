package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferSearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoneyTransferSearchServiceImpl
        extends BaseSearchServiceImpl<MoneyTransfer, MoneyTransferRepository, MoneyTransferFromEntityMapper>
        implements MoneyTransferSearchService {

    protected MoneyTransferSearchServiceImpl(
            MoneyTransferRepository repository,
            MoneyTransferFromEntityMapper mapper) {
        super(mapper, repository);
    }

    @Transactional
    @Override
    public MoneyTransfer findMoneyTransferCustom(Long id) {
        MoneyTransfer moneyTransferFull = findOneOrThrow(id);
        moneyTransferFull.getReceiveOperation();
        return moneyTransferFull;
    }
}
