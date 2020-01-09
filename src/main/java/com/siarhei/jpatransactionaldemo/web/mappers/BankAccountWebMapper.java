package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountCreationModel;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.BankAccountCreationDto;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.BankAccountViewADto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountWebMapper {

    BankAccountViewADto map(BankAccount entity);

    BankAccountCreationModel map(BankAccountCreationDto dto);

}
