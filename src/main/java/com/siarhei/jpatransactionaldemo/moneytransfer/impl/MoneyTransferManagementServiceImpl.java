package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.customer.CustomerManagementService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final CustomerManagementService customerManagementService;

    @Transactional
    @Override
    public MoneyTransfer createMoneyTransfer(MoneyTransfer moneyTransfer) {

        if (moneyTransfer.getId() != null) {
            throw new IllegalArgumentException("id must be null");
        }

        moneyTransferRepository.save(moneyTransfer);
        customerManagementService.addToBalance(moneyTransfer.getToCustomer().getId(), moneyTransfer.getAmount());
        customerManagementService.subtractFromBalance(moneyTransfer.getFromCustomer().getId(), moneyTransfer.getAmount());

        return moneyTransfer;
    }

}
