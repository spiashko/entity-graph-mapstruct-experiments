package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.CreationMapperMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = CreationMapperMappingConfig.class)
interface BankAccountCreationMapper {

    BankAccount map(BankAccountCreationModel creationModel);

}
