package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashActionManagementService;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.operation.CashRefillOperation;
import org.springframework.stereotype.Service;

@Service
public class CashRefillManagementServiceImpl
        extends AbstractCashActionManagementService<CashRefill, CashRefillOperation, CashRefillCreationModel, CashRefillMapper>
        implements CashActionManagementService<CashRefill, CashRefillCreationModel> {


    public CashRefillManagementServiceImpl(
            CashRefillMapper mapper,
            CashActionRepository cashActionRepository) {
        super(mapper, cashActionRepository);
    }
}
