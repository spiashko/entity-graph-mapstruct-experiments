package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final CustomerService customerService;


    @Override
    public MoneyTransfer createMoneyTransfer(MoneyTransfer moneyTransfer) {

        if (moneyTransfer.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be null");
        }

        moneyTransferRepository.save(moneyTransfer);

        updateFromCustomer(moneyTransfer);

        if (true) {
            throw new RuntimeException();
        }

        updateToCustomer(moneyTransfer);

        return moneyTransfer;
    }

    @Override
    public MoneyTransfer getMoneyTransferById(Long id) {
        return moneyTransferRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("customer with id=%d not found", id)));
    }

    @Override
    public List<MoneyTransfer> getMoneyTransfers() {

        List<MoneyTransfer> all = moneyTransferRepository.findAll();

        return all;
    }

    private void updateFromCustomer(MoneyTransfer moneyTransfer) {
        Customer customer = customerService.getCustomerById(moneyTransfer.getFromCustomer().getId());
        Long fromCustomerNewBalance =
                customer.getBalance() - moneyTransfer.getAmount();
        customerService.updateBalance(customer.getId(), fromCustomerNewBalance);
    }

    private void updateToCustomer(MoneyTransfer moneyTransfer) {
        Customer customer = customerService.getCustomerById(moneyTransfer.getToCustomer().getId());
        Long toCustomerNewBalance =
                customer.getBalance() + moneyTransfer.getAmount();
        customerService.updateBalance(customer.getId(), toCustomerNewBalance);
    }

}
