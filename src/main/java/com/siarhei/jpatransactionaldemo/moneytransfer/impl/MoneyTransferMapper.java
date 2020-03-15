package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromModelToEntityMapper;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferCreationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MoneyTransferMapper extends BaseFromModelToEntityMapper<MoneyTransfer, MoneyTransferCreationModel> {

}
