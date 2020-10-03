package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.BaseFromModelToEntityMapper;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MoneyTransferMapper extends BaseFromModelToEntityMapper<MoneyTransfer, MoneyTransferCreationModel> {

}
