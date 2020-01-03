package com.siarhei.jpatransactionaldemo.bankaccount;

public interface BankAccountManagementService {

    BankAccount createBankAccount(BankAccount customer);

    void deleteBankAccountById(Long id);

    void addToBalance(Long id, Long amount);

    void subtractFromBalance(Long id, Long amount);

}
