package com.siarhei.jpaefficiencyexperiments.bankaccount;

public interface BankAccountManagementService {

    BankAccountViewAModel createBankAccount(BankAccountCreationModel createModel);

    void deleteBankAccountById(Long id);

}
