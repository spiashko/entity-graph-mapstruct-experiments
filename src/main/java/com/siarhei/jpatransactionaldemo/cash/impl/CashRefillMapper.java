package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashRefillModel;
import com.siarhei.jpatransactionaldemo.cash.CreateCashRefillModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseEntityModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashRefillMapper extends BaseEntityModelMapper<CashRefill, CashRefillModel, CreateCashRefillModel> {

    CashRefill map(CreateCashRefillModel model);

    CashRefillModel map(CashRefill entity);

}
