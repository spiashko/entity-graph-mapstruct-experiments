package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountManagementService;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class BankAccountManagementServiceImpl implements BankAccountManagementService {

    private final BankAccountRepository customerRepository;
    private final BankAccountSearchService customerSearchService;

    @Override
    public BankAccount createBankAccount(BankAccount customer) {

        if (customer.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be null");
        }

        return customerRepository.save(customer);
    }

    @Override
    public void deleteBankAccountById(Long id) {

        customerRepository.deleteById(id);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void addToBalance(Long id, Long amount) {
        BankAccount customer = customerSearchService.findOneOrThrow(id);
        customer.setBalance(customer.getBalance() + amount);
        customerRepository.save(customer);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void subtractFromBalance(Long id, Long amount) {
        BankAccount customer = customerSearchService.findOneOrThrow(id);
        customer.setBalance(customer.getBalance() - amount);
        customerRepository.save(customer);
    }
}
