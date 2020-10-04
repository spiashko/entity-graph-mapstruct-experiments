package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.FromEntityMapper;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.RequestedClassNotSupportedException;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewBModel;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewC;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewCModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationViewCFromEntityMapper extends FromEntityMapper<OperationViewC> {

    OperationViewCModel mapToViewC(OperationViewC entity);

    default <T> T map(OperationViewC entity, Class<T> clazz) {
        if (OperationViewCModel.class.equals(clazz)) {
            return (T) mapToViewC(entity);
        } else {
            throw new RequestedClassNotSupportedException(clazz);
        }
    }
}
