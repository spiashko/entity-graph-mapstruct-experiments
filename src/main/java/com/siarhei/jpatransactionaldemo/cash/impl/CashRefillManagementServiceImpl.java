package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashRefill;
import com.siarhei.jpatransactionaldemo.cash.CashRefillCreationModel;
import com.siarhei.jpatransactionaldemo.operation.CashRefillOperation;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class CashRefillManagementServiceImpl
        extends AbstractCashActionManagementService<CashRefill, CashRefillOperation, CashRefillCreationModel, CashRefillMapper>
        implements CashActionManagementService<CashRefill, CashRefillCreationModel> {

    public CashRefillManagementServiceImpl(CashRefillMapper mapper, BankAccountSearchService bankAccountSearchService, OperationManagementService operationManagementService) {
        super(mapper, bankAccountSearchService, operationManagementService);
    }

    @Override
    protected Consumer<CashRefillOperation> operationSaveMethod() {
        return operationManagementService::create;
    }

    @Override
    protected CashRefillOperation instantiateOperationEntity(CashRefill cashAction) {
        CashRefillOperation cashRefillOperation = new CashRefillOperation();
        cashAction.setCashRefillOperation(cashRefillOperation);
        return cashRefillOperation;
    }
}
