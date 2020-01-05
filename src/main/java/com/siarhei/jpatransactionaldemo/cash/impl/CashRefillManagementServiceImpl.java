package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccountSearchEntityService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashRefillModel;
import com.siarhei.jpatransactionaldemo.cash.CreateCashRefillModel;
import com.siarhei.jpatransactionaldemo.operation.impl.CashRefillOperation;
import org.springframework.stereotype.Service;

@Service
public class CashRefillManagementServiceImpl
        extends AbstractCashActionManagementService<CashRefill, CashRefillOperation, CashRefillRepository, CashRefillModel, CreateCashRefillModel, CashRefillMapper>
        implements CashActionManagementService<CashRefillModel, CreateCashRefillModel> {


    public CashRefillManagementServiceImpl(CashRefillRepository repository, CashRefillMapper mapper, BankAccountSearchEntityService bankAccountSearchService) {
        super(repository, mapper, bankAccountSearchService);
    }

    @Override
    protected CashRefillOperation attachOperation(CashRefill cashAction) {
        CashRefillOperation cashRefillOperation = new CashRefillOperation();
        cashAction.setCashRefillOperation(cashRefillOperation);
        return cashRefillOperation;
    }
}
