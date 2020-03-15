package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.operation.CashRefillOperation;
import com.siarhei.jpatransactionaldemo.operation.CashWithdrawalOperation;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import com.siarhei.jpatransactionaldemo.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.SendMoneyTransferOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationManagementServiceImpl implements OperationManagementService {

    private final CashRefillOperationRepository cashRefillOperationRepository;
    private final CashWithdrawalOperationRepository cashWithdrawalOperationRepository;
    private final ReceiveMoneyTransferOperationRepository receiveMoneyTransferOperationRepository;
    private final SendMoneyTransferOperationRepository sendMoneyTransferOperationRepository;

    @Override
    public CashRefillOperation create(CashRefillOperation entity) {
        return cashRefillOperationRepository.save(entity);
    }

    @Override
    public CashWithdrawalOperation create(CashWithdrawalOperation entity) {
        return cashWithdrawalOperationRepository.save(entity);
    }

    @Override
    public SendMoneyTransferOperation create(SendMoneyTransferOperation entity) {
        return sendMoneyTransferOperationRepository.save(entity);
    }

    @Override
    public ReceiveMoneyTransferOperation create(ReceiveMoneyTransferOperation entity) {
        return receiveMoneyTransferOperationRepository.save(entity);
    }
}
