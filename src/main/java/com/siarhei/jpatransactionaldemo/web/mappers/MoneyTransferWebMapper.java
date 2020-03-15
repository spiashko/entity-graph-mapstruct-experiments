package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferCreationDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferViewBDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MoneyTransferWebMapper {

    MoneyTransferViewADto mapToViewA(MoneyTransfer entity);

    @Mappings({
            @Mapping(target = "fromBankAccountId", source = "sendOperation.bankAccount.id"),
            @Mapping(target = "toBankAccountId", source = "receiveOperation.bankAccount.id")
    })
    MoneyTransferViewBDto mapToViewB(MoneyTransfer entity);

    MoneyTransferCreationModel map(MoneyTransferCreationDto moneyTransfer);

}
