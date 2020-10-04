package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashWithdrawalMapper {

    CashWithdrawal map(CashWithdrawalCreationModel creationModel);

}
