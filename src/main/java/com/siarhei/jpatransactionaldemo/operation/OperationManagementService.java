package com.siarhei.jpatransactionaldemo.operation;

public interface OperationManagementService {

    CashRefillOperation create(CashRefillOperation entity);

    CashWithdrawalOperation create(CashWithdrawalOperation entity);

    SendMoneyTransferOperation create(SendMoneyTransferOperation entity);

    ReceiveMoneyTransferOperation create(ReceiveMoneyTransferOperation entity);

}
