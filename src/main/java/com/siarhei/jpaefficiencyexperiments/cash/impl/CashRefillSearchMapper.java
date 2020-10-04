package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface CashRefillSearchMapper {

    @Mapping(target = "cashRefillOperation.bankAccountId", source = "cashRefillOperation.bankAccount.id")
    CashRefillViewBModel mapToViewB(CashRefill entity);

    @Mapping(target = "bankAccountId", source = "cashRefillOperation.bankAccount.id")
    CashRefillViewAModel mapToViewA(CashRefill entity);

}
