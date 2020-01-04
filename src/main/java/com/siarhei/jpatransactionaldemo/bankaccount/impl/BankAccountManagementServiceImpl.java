package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class BankAccountManagementServiceImpl implements BankAccountManagementService {

    private final BankAccountRepository customerRepository;

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
}
