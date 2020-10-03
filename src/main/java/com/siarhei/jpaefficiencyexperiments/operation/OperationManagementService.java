package com.siarhei.jpaefficiencyexperiments.operation;

public interface OperationManagementService {

    CashRefillOperation create(CashRefillOperation entity);

    CashWithdrawalOperation create(CashWithdrawalOperation entity);

}
