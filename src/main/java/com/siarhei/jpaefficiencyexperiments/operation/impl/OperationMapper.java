package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.operation.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface OperationMapper {

    OperationViewBModel mapToViewB(OperationSummary entity);

    OperationViewAModel mapToViewA(OperationSummary entity);

    OperationViewCModel mapToViewC(OperationViewC entity);

}
