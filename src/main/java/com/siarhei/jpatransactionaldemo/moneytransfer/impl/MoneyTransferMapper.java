package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseEntityModelMapper;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromEntityToModelMapper;
import com.siarhei.jpatransactionaldemo.moneytransfer.CreateMoneyTransferModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferModel;
import com.siarhei.jpatransactionaldemo.operation.OperationModel;
import com.siarhei.jpatransactionaldemo.operation.impl.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MoneyTransferMapper extends BaseEntityModelMapper<MoneyTransfer, MoneyTransferModel, CreateMoneyTransferModel> {

    MoneyTransferModel map(MoneyTransfer entity);
    MoneyTransfer map(CreateMoneyTransferModel entity);

}
