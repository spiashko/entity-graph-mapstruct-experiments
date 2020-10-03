package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.BaseFromModelToEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashWithdrawalMapper extends BaseFromModelToEntityMapper<CashWithdrawal, CashWithdrawalCreationModel> {

}
