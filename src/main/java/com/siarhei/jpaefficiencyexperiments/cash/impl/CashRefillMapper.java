package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.BaseFromModelToEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashRefillMapper extends BaseFromModelToEntityMapper<CashRefill, CashRefillCreationModel> {

}
