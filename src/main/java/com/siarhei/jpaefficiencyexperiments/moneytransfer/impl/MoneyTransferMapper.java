package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewAModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MoneyTransferMapper {

    MoneyTransfer map(MoneyTransferCreationModel creationModel);

    MoneyTransferViewBModel mapToViewB(MoneyTransfer entity);

    MoneyTransferViewAModel mapToViewA(MoneyTransfer entity);

}
