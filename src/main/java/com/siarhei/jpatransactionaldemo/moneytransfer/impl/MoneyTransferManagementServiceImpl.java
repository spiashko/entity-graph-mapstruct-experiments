package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccountSearchEntityService;
import com.siarhei.jpatransactionaldemo.moneytransfer.CreateMoneyTransferModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferModel;
import com.siarhei.jpatransactionaldemo.operation.impl.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.impl.SendMoneyTransferOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final MoneyTransferMapper mapper;
    private final BankAccountSearchEntityService bankAccountSearchService;

    @Override
    public MoneyTransferModel createMoneyTransfer(CreateMoneyTransferModel createModel) {

        MoneyTransfer moneyTransfer = mapper.map(createModel);

        SendMoneyTransferOperation sendOperation =
                SendMoneyTransferOperation.builder()
                        .amount(createModel.getAmount())
                        .moneyTransfer(moneyTransfer)
                        .bankAccount(getBankAccount(createModel.getFromBankAccountId()))
                        .build();

        moneyTransfer.setSendOperation(sendOperation);

        ReceiveMoneyTransferOperation receiveOperation =
                ReceiveMoneyTransferOperation.builder()
                        .amount(createModel.getAmount())
                        .moneyTransfer(moneyTransfer)
                        .bankAccount(getBankAccount(createModel.getToBankAccountId()))
                        .build();

        moneyTransfer.setReceiveOperation(receiveOperation);

        moneyTransferRepository.save(moneyTransfer);

        return mapper.map(moneyTransfer);
    }

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneEntityOrThrow(bankAccountId);
    }

}
