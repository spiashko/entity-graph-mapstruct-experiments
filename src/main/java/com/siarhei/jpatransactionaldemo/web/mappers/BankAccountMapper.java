package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.CreateBankAccountDto;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.RetrieveBankAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    RetrieveBankAccountDto map(BankAccount customer);

    BankAccount map(CreateBankAccountDto customer);

}
