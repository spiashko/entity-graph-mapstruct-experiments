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
            @Mapping(target = "toCustomerId", source = "toCustomer.id"),
            @Mapping(target = "fromCustomerId", source = "fromCustomer.id")
    })
    RetrieveMoneyTransferDto map(MoneyTransfer moneyTransfer);

    @Mappings({
            @Mapping(target = "toCustomer.id", source = "toCustomerId"),
            @Mapping(target = "fromCustomer.id", source = "fromCustomerId")
    })
    MoneyTransfer map(CreateMoneyTransferDto moneyTransfer);

}
