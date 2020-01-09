package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashRefill;
import com.siarhei.jpatransactionaldemo.cash.CashRefillCreationModel;
import com.siarhei.jpatransactionaldemo.operation.CashRefillOperation;
import org.springframework.stereotype.Service;

@Service
public class CashRefillManagementServiceImpl
        extends AbstractCashActionManagementService<CashRefill, CashRefillOperation, CashRefillRepository, CashRefillCreationModel, CashRefillMapper>
        implements CashActionManagementService<CashRefill, CashRefillCreationModel> {

    public CashRefillManagementServiceImpl(CashRefillRepository repository, CashRefillMapper mapper, BankAccountSearchService bankAccountSearchService) {
        super(repository, mapper, bankAccountSearchService);
    }

    @Override
    protected CashRefillOperation attachOperation(CashRefill cashAction) {
        CashRefillOperation cashRefillOperation = new CashRefillOperation();
        cashAction.setCashRefillOperation(cashRefillOperation);
        return cashRefillOperation;
    }
}
