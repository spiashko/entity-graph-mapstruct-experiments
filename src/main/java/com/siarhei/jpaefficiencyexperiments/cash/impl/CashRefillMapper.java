package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface CashRefillMapper {

    @Mapping(target = "cashRefillOperation.bankAccount.id", source = "bankAccountId")
    @Mapping(target = "cashRefillOperation.amount", source = "cashAmount")
    CashRefill map(CashRefillCreationModel creationModel);

    @Mapping(target = "cashRefillOperation.bankAccountId", source = "cashRefillOperation.bankAccount.id")
    CashRefillViewBModel mapToViewB(CashRefill entity);

    @Mapping(target = "bankAccountId", source = "cashRefillOperation.bankAccount.id")
    CashRefillViewAModel mapToViewA(CashRefill entity);

}
