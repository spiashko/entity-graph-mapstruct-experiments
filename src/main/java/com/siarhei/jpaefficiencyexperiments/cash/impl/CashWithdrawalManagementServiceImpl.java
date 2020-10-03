package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashActionManagementService;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.operation.CashWithdrawalOperation;
import org.springframework.stereotype.Service;

@Service
public class CashWithdrawalManagementServiceImpl
        extends AbstractCashActionManagementService<CashWithdrawal, CashWithdrawalOperation, CashWithdrawalCreationModel, CashWithdrawalMapper>
        implements CashActionManagementService<CashWithdrawal, CashWithdrawalCreationModel> {


    public CashWithdrawalManagementServiceImpl(
            CashWithdrawalMapper mapper,
            CashActionRepository cashActionRepository) {
        super(mapper, cashActionRepository);
    }
}
