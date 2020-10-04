package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.ToEntityMapperSupport;
import com.siarhei.jpaefficiencyexperiments.operation.CashWithdrawalOperation;
import org.mapstruct.*;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface CashWithdrawalCreationMapper extends ToEntityMapperSupport {

    @Mapping(target = "cashWithdrawalOperation.bankAccount", source = "bankAccountId")
    @Mapping(target = "cashWithdrawalOperation.amount", source = "cashAmount", qualifiedByName = "operationAmountProvider")
    CashWithdrawal map(CashWithdrawalCreationModel creationModel, @Context Long fee,
                       @Context EntityManager entityManager, @Context BiDirectionalReferences references);

    @Named("operationAmountProvider")
    default Long calcOperationAmountBasedOnRequestedCashAmount(Long cashAmount, @Context Long fee) {
        return cashAmount + fee;
    }

    @AfterMapping
    default void populateFee(@MappingTarget CashWithdrawal entity, @Context Long fee) {
        entity.setFee(fee);
    }

    default CashWithdrawal map(CashWithdrawalCreationModel creationModel, @Context Long fee,
                               @Context EntityManager entityManager) {
        return map(creationModel, fee, entityManager, new BiDirectionalReferences());
    }

    class BiDirectionalReferences {

        private CashWithdrawal parentEntity;

        @BeforeMapping
        public void setEntity(@MappingTarget CashWithdrawal parentEntity) {
            this.parentEntity = parentEntity;
        }

        @AfterMapping
        public void establishRelation(@MappingTarget CashWithdrawalOperation.CashWithdrawalOperationBuilder childEntity) {
            childEntity.cashWithdrawal(parentEntity);
        }
    }

}
