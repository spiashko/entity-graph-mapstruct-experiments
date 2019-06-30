package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final CustomerService customerService;

    public MoneyTransferServiceImpl(MoneyTransferRepository moneyTransferRepository, CustomerService customerService) {
        this.moneyTransferRepository = moneyTransferRepository;
        this.customerService = customerService;
    }

    @Override
    public MoneyTransfer createMoneyTransfer(MoneyTransfer moneyTransfer) {

        if (moneyTransfer.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be null");
        }

        moneyTransferRepository.save(moneyTransfer);

        updateFromCustomer(moneyTransfer);
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
        return moneyTransferRepository.findAll();
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
