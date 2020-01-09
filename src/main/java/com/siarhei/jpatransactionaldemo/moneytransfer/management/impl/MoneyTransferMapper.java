package com.siarhei.jpatransactionaldemo.moneytransfer.management.impl;

import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromModelToEntityMapper;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
import com.siarhei.jpatransactionaldemo.moneytransfer.management.MoneyTransferCreationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MoneyTransferMapper extends BaseFromModelToEntityMapper<MoneyTransferFull, MoneyTransferCreationModel> {

}
