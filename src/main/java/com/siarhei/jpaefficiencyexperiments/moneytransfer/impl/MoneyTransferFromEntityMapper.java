package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.FromEntityMapper;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.RequestedClassNotSupportedException;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewAModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoneyTransferFromEntityMapper extends FromEntityMapper<MoneyTransfer> {

    MoneyTransferViewBModel mapToViewB(MoneyTransfer entity);

    MoneyTransferViewAModel mapToViewA(MoneyTransfer entity);

    default <T> T map(MoneyTransfer entity, Class<T> clazz) {
        if (MoneyTransferViewBModel.class.equals(clazz)) {
            return (T) mapToViewB(entity);
        } else if (MoneyTransferViewAModel.class.equals(clazz)) {
            return (T) mapToViewA(entity);
        } else {
            throw new RequestedClassNotSupportedException(clazz);
        }
    }
}
