package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashRefill;
import com.siarhei.jpatransactionaldemo.cash.CashRefillCreationModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromModelToEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashRefillMapper extends BaseFromModelToEntityMapper<CashRefill, CashRefillCreationModel> {

}
