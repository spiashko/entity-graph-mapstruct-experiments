package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashActionModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromEntityToModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashActionMapper extends BaseFromEntityToModelMapper<CashAction, CashActionModel> {

    CashActionModel map(CashAction entity);

}
