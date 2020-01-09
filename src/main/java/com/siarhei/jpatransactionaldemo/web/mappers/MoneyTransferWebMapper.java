package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
import com.siarhei.jpatransactionaldemo.moneytransfer.management.MoneyTransferCreationModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummary;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferCreationDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferViewBDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MoneyTransferWebMapper {

    MoneyTransferViewADto mapToViewA(MoneyTransferSummary entity);

    @Mappings({
            @Mapping(target = "fromBankAccountId", source = "sendOperation.bankAccount.id"),
            @Mapping(target = "toBankAccountId", source = "receiveOperation.bankAccount.id")
    })
    MoneyTransferViewBDto mapToViewB(MoneyTransferFull entity);

    MoneyTransferCreationModel map(MoneyTransferCreationDto moneyTransfer);

}
