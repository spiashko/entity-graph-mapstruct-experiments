package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.moneytransfer.CreateMoneyTransferModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferModel;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.CreateMoneyTransferDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.RetrieveMoneyTransferDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MoneyTransferWebMapper {

    @Mappings({
            @Mapping(target = "toBankAccountId", source = "sendOperation.bankAccount.id"),
            @Mapping(target = "fromBankAccountId", source = "receiveOperation.bankAccount.id")
    })
    RetrieveMoneyTransferDto map(MoneyTransferModel moneyTransfer);

    CreateMoneyTransferModel map(CreateMoneyTransferDto moneyTransfer);

}
