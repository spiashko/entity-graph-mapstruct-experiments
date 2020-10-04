package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewBModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface CashWithdrawalSearchMapper {

    @Mapping(target = "cashWithdrawalOperation.bankAccountId", source = "cashWithdrawalOperation.bankAccount.id")
    CashWithdrawalViewBModel mapToViewB(CashWithdrawal entity);

    @Mapping(target = "bankAccountId", source = "cashWithdrawalOperation.bankAccount.id")
    CashWithdrawalViewAModel mapToViewA(CashWithdrawal entity);

}
