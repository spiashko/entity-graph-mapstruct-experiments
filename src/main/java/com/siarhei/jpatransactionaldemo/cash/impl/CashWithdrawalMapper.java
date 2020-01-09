package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashWithdrawal;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawalCreationModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromModelToEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashWithdrawalMapper extends BaseFromModelToEntityMapper<CashWithdrawal, CashWithdrawalCreationModel> {

}
