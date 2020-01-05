package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccountSearchEntityService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawalModel;
import com.siarhei.jpatransactionaldemo.cash.CreateCashWithdrawalModel;
import com.siarhei.jpatransactionaldemo.operation.impl.CashWithdrawalOperation;
import org.springframework.stereotype.Service;

@Service
public class CashWithdrawalManagementServiceImpl
        extends AbstractCashActionManagementService<CashWithdrawal, CashWithdrawalOperation, CashWithdrawalRepository, CashWithdrawalModel, CreateCashWithdrawalModel, CashWithdrawalMapper>
        implements CashActionManagementService<CashWithdrawalModel, CreateCashWithdrawalModel> {

    public CashWithdrawalManagementServiceImpl(CashWithdrawalRepository repository, CashWithdrawalMapper mapper, BankAccountSearchEntityService bankAccountSearchService) {
        super(repository, mapper, bankAccountSearchService);
    }

    @Override
    protected CashWithdrawalOperation attachOperation(CashWithdrawal cashAction) {
        CashWithdrawalOperation cashWithdrawalOperation = new CashWithdrawalOperation();
        cashAction.setCashWithdrawalOperation(cashWithdrawalOperation);
        return cashWithdrawalOperation;
    }
}
