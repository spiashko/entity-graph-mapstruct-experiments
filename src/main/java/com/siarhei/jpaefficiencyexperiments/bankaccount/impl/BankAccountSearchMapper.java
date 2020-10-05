package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewBModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.SearchMapperMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = SearchMapperMappingConfig.class)
interface BankAccountSearchMapper {

    BankAccountViewBModel mapToViewB(BankAccount entity);

    BankAccountViewAModel mapToViewA(BankAccount entity);

}
