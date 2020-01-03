package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountManagementService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final BankAccountManagementService customerManagementService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public MoneyTransfer createMoneyTransfer(MoneyTransfer moneyTransfer) {

        if (moneyTransfer.getId() != null) {
            throw new IllegalArgumentException("id must be null");
        }

        moneyTransferRepository.save(moneyTransfer);
        customerManagementService.addToBalance(moneyTransfer.getToBankAccount().getId(), moneyTransfer.getAmount());
        customerManagementService.subtractFromBalance(moneyTransfer.getFromBankAccount().getId(), moneyTransfer.getAmount());

        return moneyTransfer;
    }

}
