package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.operation.CashRefillOperation;
import com.siarhei.jpaefficiencyexperiments.operation.CashWithdrawalOperation;
import com.siarhei.jpaefficiencyexperiments.operation.OperationManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationManagementServiceImpl implements OperationManagementService {

    private final CashRefillOperationRepository cashRefillOperationRepository;
    private final CashWithdrawalOperationRepository cashWithdrawalOperationRepository;

    @Override
    public CashRefillOperation create(CashRefillOperation entity) {
        return cashRefillOperationRepository.save(entity);
    }

    @Override
    public CashWithdrawalOperation create(CashWithdrawalOperation entity) {
        return cashWithdrawalOperationRepository.save(entity);
    }

}
