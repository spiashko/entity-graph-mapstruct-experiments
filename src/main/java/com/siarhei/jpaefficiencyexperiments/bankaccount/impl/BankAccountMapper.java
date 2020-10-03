package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BankAccountMapper {

    BankAccount map(BankAccountCreationModel creationModel);

}
