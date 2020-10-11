package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.SearchMapperMappingConfig;
import com.siarhei.jpaefficiencyexperiments.operation.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SearchMapperMappingConfig.class)
interface OperationSearchMapper {

    @Mapping(target = "bankAccountId", source = "bankAccount.id")
    OperationViewAModel mapToViewA(OperationSummary entity);

    OperationViewBModel mapToViewB(OperationSummary entity);

    OperationViewCModel mapToViewC(OperationViewC entity);

}
