package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.view.BankAccountCreateView;
import com.siarhei.jpatransactionaldemo.bankaccount.service.BankAccountManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BankAccountManagementServiceImpl implements BankAccountManagementService {

    private final BankAccountRepository repository;
    private final BankAccountMapper mapper;

    @Override
    public BankAccount createBankAccount(BankAccountCreateView creationModel) {
        BankAccount bankAccount = mapper.map(creationModel);
        repository.save(bankAccount);
        return bankAccount;
    }

    @Override
    public void deleteBankAccountById(Long id) {
        repository.deleteById(id);
    }
}
