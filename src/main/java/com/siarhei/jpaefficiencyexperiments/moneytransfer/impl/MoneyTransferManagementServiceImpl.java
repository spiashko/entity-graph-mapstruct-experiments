package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountSearchService;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import com.siarhei.jpaefficiencyexperiments.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpaefficiencyexperiments.operation.SendMoneyTransferOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferRepository repository;
    private final MoneyTransferMapper mapper;
    private final BankAccountSearchService bankAccountSearchService;

    @Override
    @Transactional
    public MoneyTransferViewBModel createMoneyTransfer(MoneyTransferCreationModel createModel) {

        MoneyTransfer moneyTransfer = mapper.map(createModel);

        SendMoneyTransferOperation sendOperation =
                SendMoneyTransferOperation.builder()
                        .sendMoneyTransfer(moneyTransfer)
                        .amount(createModel.getAmount())
                        .bankAccount(getBankAccount(createModel.getFromBankAccountId()))
                        .build();

        ReceiveMoneyTransferOperation receiveOperation =
                ReceiveMoneyTransferOperation.builder()
                        .receiveMoneyTransfer(moneyTransfer)
                        .amount(createModel.getAmount())
                        .bankAccount(getBankAccount(createModel.getToBankAccountId()))
                        .build();

        moneyTransfer.setSendOperation(sendOperation);
        moneyTransfer.setReceiveOperation(receiveOperation);

        repository.save(moneyTransfer);

        return mapper.mapToViewB(moneyTransfer);
    }

    private BankAccount getBankAccount(Long bankAccountId) {
        return bankAccountSearchService.findOneOrThrow(bankAccountId);
    }

}
