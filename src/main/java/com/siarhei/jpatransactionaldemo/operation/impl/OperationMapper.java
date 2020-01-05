package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseFromEntityToModelMapper;
import com.siarhei.jpatransactionaldemo.operation.OperationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface OperationMapper extends BaseFromEntityToModelMapper<Operation, OperationModel> {

    OperationModel map(Operation entity);

}
