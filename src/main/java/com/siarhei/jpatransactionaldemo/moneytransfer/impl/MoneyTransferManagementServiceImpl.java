package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.service.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpatransactionaldemo.operation.OperationManagementService;
import com.siarhei.jpatransactionaldemo.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.SendMoneyTransferOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferRepository repository;
    private final MoneyTransferMapper mapper;
    private final BankAccountSearchService bankAccountSearchService;
    private final OperationManagementService operationManagementService;

    @Override
    public MoneyTransfer createMoneyTransfer(MoneyTransferCreationModel createModel) {

        MoneyTransfer moneyTransfer = mapper.map(createModel);

        SendMoneyTransferOperation sendOperation =
                SendMoneyTransferOperation.builder()
                        .amount(createModel.getAmount())
                        .bankAccount(getBankAccount(createModel.getFromBankAccountId()))
                        .build();
        operationManagementService.create(sendOperation);

        ReceiveMoneyTransferOperation receiveOperation =
                ReceiveMoneyTransferOperation.builder()
                        .amount(createModel.getAmount())
                        .bankAccount(getBankAccount(createModel.getToBankAccountId()))
                        .build();
        operationManagementService.create(receiveOperation);

        moneyTransfer.setSendOperation(sendOperation);
        moneyTransfer.setReceiveOperation(receiveOperation);

        repository.save(moneyTransfer);

        return moneyTransfer;
    }

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneOrThrow(bankAccountId);
    }

}
