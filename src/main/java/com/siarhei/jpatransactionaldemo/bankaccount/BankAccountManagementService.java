package com.siarhei.jpatransactionaldemo.bankaccount;

public interface BankAccountManagementService {

    BankAccount createBankAccount(BankAccountCreationModel createModel);

    void deleteBankAccountById(Long id);

}
