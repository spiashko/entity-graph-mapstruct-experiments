package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountManagementService;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountModel;
import com.siarhei.jpatransactionaldemo.bankaccount.CreateBankAccountModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BankAccountManagementServiceImpl implements BankAccountManagementService {

    private final BankAccountRepository repository;
    private final BankAccountMapper mapper;

    @Override
    public BankAccountModel createBankAccount(CreateBankAccountModel createModel) {
        BankAccount bankAccount = mapper.map(createModel);
        repository.save(bankAccount);
        return mapper.map(bankAccount);
    }

    @Override
    public void deleteBankAccountById(Long id) {
        repository.deleteById(id);
    }
}
