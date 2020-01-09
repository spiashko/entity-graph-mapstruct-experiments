package com.siarhei.jpatransactionaldemo.moneytransfer.management.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.impl.MoneyTransferFullRepository;
import com.siarhei.jpatransactionaldemo.moneytransfer.management.MoneyTransferCreationModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.management.MoneyTransferManagementService;
import com.siarhei.jpatransactionaldemo.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.SendMoneyTransferOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferFullRepository repository;
    private final MoneyTransferMapper mapper;
    private final BankAccountSearchService bankAccountSearchService;

    @Override
    public MoneyTransferFull createMoneyTransfer(MoneyTransferCreationModel createModel) {

        MoneyTransferFull moneyTransferFull = mapper.map(createModel);

        SendMoneyTransferOperation sendOperation =
                SendMoneyTransferOperation.builder()
                        .amount(createModel.getAmount())
                        .moneyTransfer(moneyTransferFull)
                        .bankAccount(getBankAccount(createModel.getFromBankAccountId()))
                        .build();

        moneyTransferFull.setSendOperation(sendOperation);

        ReceiveMoneyTransferOperation receiveOperation =
                ReceiveMoneyTransferOperation.builder()
                        .amount(createModel.getAmount())
                        .moneyTransfer(moneyTransferFull)
                        .bankAccount(getBankAccount(createModel.getToBankAccountId()))
                        .build();

        moneyTransferFull.setReceiveOperation(receiveOperation);

        repository.save(moneyTransferFull);

        return moneyTransferFull;
    }

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneOrThrow(bankAccountId);
    }

}
