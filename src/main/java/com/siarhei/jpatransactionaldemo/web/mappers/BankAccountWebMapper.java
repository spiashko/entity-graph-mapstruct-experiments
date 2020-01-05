package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountModel;
import com.siarhei.jpatransactionaldemo.bankaccount.CreateBankAccountModel;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.CreateBankAccountDto;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.RetrieveBankAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountWebMapper {

    RetrieveBankAccountDto map(BankAccountModel model);

    CreateBankAccountModel map(CreateBankAccountDto dto);

}
