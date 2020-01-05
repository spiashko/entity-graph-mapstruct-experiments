package com.siarhei.jpatransactionaldemo.bankaccount;

public interface BankAccountManagementService {

    BankAccountModel createBankAccount(CreateBankAccountModel createModel);

    void deleteBankAccountById(Long id);

}
