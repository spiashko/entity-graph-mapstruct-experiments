package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewAModel;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalViewBModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.SearchMapperMappingConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SearchMapperMappingConfig.class)
interface CashWithdrawalSearchMapper {

    @Mapping(target = "cashWithdrawalOperation.bankAccountId", source = "cashWithdrawalOperation.bankAccount.id")
    CashWithdrawalViewBModel mapToViewB(CashWithdrawal entity);

    CashWithdrawalViewAModel mapToViewA(CashWithdrawal entity);

}
