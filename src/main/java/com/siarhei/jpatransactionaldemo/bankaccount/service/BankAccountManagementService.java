package com.siarhei.jpatransactionaldemo.bankaccount.service;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.view.BankAccountCreateView;

public interface BankAccountManagementService {

    BankAccount createBankAccount(BankAccountCreateView createModel);

    void deleteBankAccountById(Long id);

}
