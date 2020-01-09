package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountCreationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BankAccountMapper {

    BankAccount map(BankAccountCreationModel creationModel);

}
