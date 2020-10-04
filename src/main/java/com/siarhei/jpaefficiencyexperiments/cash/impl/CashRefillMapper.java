package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillViewBModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashRefillMapper {

    CashRefill map(CashRefillCreationModel creationModel);

    CashRefillViewBModel mapToViewB(CashRefill entity);

    CashRefillViewAModel mapToViewA(CashRefill entity);

}
