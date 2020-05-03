package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.view.BankAccountCreateView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BankAccountMapper {

    BankAccount map(BankAccountCreateView creationModel);

}
