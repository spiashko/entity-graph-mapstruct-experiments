package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.dto.MoneyTransferDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MoneyTransferMapper {

    @Mappings({
            @Mapping(target = "toCustomerId", source = "toCustomer.id"),
            @Mapping(target = "fromCustomerId", source = "fromCustomer.id")
    })
    MoneyTransferDto map(MoneyTransfer moneyTransfer);

}
