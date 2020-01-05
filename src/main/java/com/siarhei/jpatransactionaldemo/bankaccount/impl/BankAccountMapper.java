package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountModel;
import com.siarhei.jpatransactionaldemo.bankaccount.CreateBankAccountModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseEntityModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BankAccountMapper extends BaseEntityModelMapper<BankAccount, BankAccountModel, CreateBankAccountModel> {

    BankAccount map(CreateBankAccountModel model);
    BankAccountModel map(BankAccount bankAccount);

}
