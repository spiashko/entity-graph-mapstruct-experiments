package com.siarhei.jpatransactionaldemo.bankaccount;

public interface BankAccountManagementService {

    BankAccount createBankAccount(BankAccount customer);

    void deleteBankAccountById(Long id);

}
