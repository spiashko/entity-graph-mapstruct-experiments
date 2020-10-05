package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.SearchMapperMappingConfig;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewAModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SearchMapperMappingConfig.class)
interface MoneyTransferSearchMapper {

    @Mapping(target = "fromBankAccountId", source = "sendOperation.bankAccount.id")
    @Mapping(target = "toBankAccountId", source = "receiveOperation.bankAccount.id")
    MoneyTransferViewBModel mapToViewB(MoneyTransfer entity);

    MoneyTransferViewAModel mapToViewA(MoneyTransfer entity);

}
