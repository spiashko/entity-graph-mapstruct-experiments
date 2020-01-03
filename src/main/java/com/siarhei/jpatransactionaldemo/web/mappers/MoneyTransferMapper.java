package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.CreateMoneyTransferDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.RetrieveMoneyTransferDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MoneyTransferMapper {

    @Mappings({
            @Mapping(target = "toBankAccountId", source = "toBankAccount.id"),
            @Mapping(target = "fromBankAccountId", source = "fromBankAccount.id")
    })
    RetrieveMoneyTransferDto map(MoneyTransfer moneyTransfer);

    @Mappings({
            @Mapping(target = "toBankAccount.id", source = "toBankAccountId"),
            @Mapping(target = "fromBankAccount.id", source = "fromBankAccountId")
    })
    MoneyTransfer map(CreateMoneyTransferDto moneyTransfer);

}
