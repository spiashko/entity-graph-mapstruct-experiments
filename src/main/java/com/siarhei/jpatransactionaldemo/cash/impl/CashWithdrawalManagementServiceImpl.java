package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.cash.CashActionManagementService;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawal;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawalCreationModel;
import com.siarhei.jpatransactionaldemo.operation.CashWithdrawalOperation;
import org.springframework.stereotype.Service;

@Service
public class CashWithdrawalManagementServiceImpl
        extends AbstractCashActionManagementService<CashWithdrawal, CashWithdrawalOperation, CashWithdrawalRepository, CashWithdrawalCreationModel, CashWithdrawalMapper>
        implements CashActionManagementService<CashWithdrawal, CashWithdrawalCreationModel> {

    public CashWithdrawalManagementServiceImpl(CashWithdrawalRepository repository, CashWithdrawalMapper mapper, BankAccountSearchService bankAccountSearchService) {
        super(repository, mapper, bankAccountSearchService);
    }

    @Override
    protected CashWithdrawalOperation attachOperation(CashWithdrawal cashAction) {
        CashWithdrawalOperation cashWithdrawalOperation = new CashWithdrawalOperation();
        cashAction.setCashWithdrawalOperation(cashWithdrawalOperation);
        return cashWithdrawalOperation;
    }
}
