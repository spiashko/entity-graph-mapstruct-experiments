package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewBModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.FromEntityMapper;
import com.siarhei.jpaefficiencyexperiments.crudbase.mapper.RequestedClassNotSupportedException;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountFromEntityMapper extends FromEntityMapper<BankAccount> {

    BankAccountViewBModel mapToViewB(BankAccount entity);

    BankAccountViewAModel mapToViewA(BankAccount entity);

    default <T> T map(BankAccount entity, Class<T> clazz) {
        if (BankAccountViewBModel.class.equals(clazz)) {
            return (T) mapToViewB(entity);
        } else if (BankAccountViewAModel.class.equals(clazz)) {
            return (T) mapToViewA(entity);
        } else {
            throw new RequestedClassNotSupportedException(clazz);
        }
    }
}
