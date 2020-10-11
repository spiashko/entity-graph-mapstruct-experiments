package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.SearchMapperMappingConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SearchMapperMappingConfig.class)
interface CashRefillSearchMapper {

    @Mapping(target = "cashRefillOperation.bankAccountId", source = "cashRefillOperation.bankAccount.id")
    CashRefillViewBModel mapToViewB(CashRefill entity);

    CashRefillViewAModel mapToViewA(CashRefill entity);

}
