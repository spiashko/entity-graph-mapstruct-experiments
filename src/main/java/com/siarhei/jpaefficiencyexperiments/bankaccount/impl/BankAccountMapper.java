package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewBModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BankAccountMapper {

    BankAccount map(BankAccountCreationModel creationModel);

    BankAccountViewBModel mapToViewB(BankAccount entity);

    BankAccountViewAModel mapToViewA(BankAccount entity);

}
