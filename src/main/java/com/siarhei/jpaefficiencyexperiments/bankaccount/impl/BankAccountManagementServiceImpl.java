package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountManagementService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BankAccountManagementServiceImpl implements BankAccountManagementService {

    private final BankAccountRepository repository;
    private final BankAccountMapper mapper;
    private final BankAccountFromEntityMapper fromEntityMapper;

    @Override
    public BankAccountViewAModel createBankAccount(BankAccountCreationModel creationModel) {
        BankAccount bankAccount = mapper.map(creationModel);
        repository.save(bankAccount);
        return fromEntityMapper.mapToViewA(bankAccount);
    }

    @Override
    public void deleteBankAccountById(Long id) {
        repository.deleteById(id);
    }
}
