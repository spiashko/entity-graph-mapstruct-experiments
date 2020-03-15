package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawal;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawalCreationModel;
import com.siarhei.jpatransactionaldemo.operation.CashWithdrawalOperation;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class CashWithdrawalManagementServiceImpl
        extends AbstractCashActionManagementService<CashWithdrawal, CashWithdrawalOperation, CashWithdrawalCreationModel, CashWithdrawalMapper>
        implements CashActionManagementService<CashWithdrawal, CashWithdrawalCreationModel> {

    public CashWithdrawalManagementServiceImpl(CashWithdrawalMapper mapper, BankAccountSearchService bankAccountSearchService, OperationManagementService operationManagementService) {
        super(mapper, bankAccountSearchService, operationManagementService);
    }

    @Override
    protected Consumer<CashWithdrawalOperation> operationSaveMethod() {
        return operationManagementService::create;
    }

    @Override
    protected CashWithdrawalOperation instantiateOperationEntity(CashWithdrawal cashAction) {
        CashWithdrawalOperation cashWithdrawalOperation = new CashWithdrawalOperation();
        cashAction.setCashWithdrawalOperation(cashWithdrawalOperation);
        return cashWithdrawalOperation;
    }
}
