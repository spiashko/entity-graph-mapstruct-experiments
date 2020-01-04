package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.CreateOperationDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.RetrieveOperationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    @Mappings({
            @Mapping(target = "toBankAccountId", source = "toBankAccount.id"),
            @Mapping(target = "fromBankAccountId", source = "fromBankAccount.id")
    })
    RetrieveOperationDto map(Operation moneyTransfer);

    @Mappings({
            @Mapping(target = "toBankAccount.id", source = "toBankAccountId"),
            @Mapping(target = "fromBankAccount.id", source = "fromBankAccountId")
    })
    Operation map(CreateOperationDto moneyTransfer);

}
