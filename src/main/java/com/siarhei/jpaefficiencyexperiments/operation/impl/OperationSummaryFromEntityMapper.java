package com.siarhei.jpaefficiencyexperiments.operation.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.FromEntityMapper;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.RequestedClassNotSupportedException;
import com.siarhei.jpaefficiencyexperiments.operation.OperationSummary;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewAModel;
import com.siarhei.jpaefficiencyexperiments.operation.OperationViewBModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationSummaryFromEntityMapper extends FromEntityMapper<OperationSummary> {

    OperationViewBModel mapToViewB(OperationSummary entity);

    OperationViewAModel mapToViewA(OperationSummary entity);

    default <T> T map(OperationSummary entity, Class<T> clazz) {
        if (OperationViewBModel.class.equals(clazz)) {
            return (T) mapToViewB(entity);
        } else if (OperationViewAModel.class.equals(clazz)) {
            return (T) mapToViewA(entity);
        } else {
            throw new RequestedClassNotSupportedException(clazz);
        }
    }
}
