package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewBModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashWithdrawalMapper {

    CashWithdrawal map(CashWithdrawalCreationModel creationModel);

    CashWithdrawalViewBModel mapToViewB(CashWithdrawal entity);

    CashWithdrawalViewAModel mapToViewA(CashWithdrawal entity);

}
