package com.siarhei.jpaefficiencyexperiments.bankaccount;

import java.util.UUID;

public interface BankAccountManagementService {

    BankAccountViewAModel createBankAccount(BankAccountCreationModel createModel);

    void deleteBankAccountById(UUID id);

}
