package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefillCreationModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.ToEntityMapperSupport;
import com.siarhei.jpaefficiencyexperiments.operation.CashRefillOperation;
import org.mapstruct.*;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.ERROR)
interface CashRefillCreationMapper extends ToEntityMapperSupport {

    @Mapping(target = "cashRefillOperation.bankAccount", source = "bankAccountId")
    @Mapping(target = "cashRefillOperation.amount", source = "cashAmount")
    CashRefill map(CashRefillCreationModel creationModel, @Context EntityManager entityManager,
                   @Context BiDirectionalReferences references);

    default CashRefill map(CashRefillCreationModel creationModel, @Context EntityManager entityManager) {
        return map(creationModel, entityManager, new BiDirectionalReferences());
    }

    class BiDirectionalReferences {

        private CashRefill parentEntity;

        @BeforeMapping
        public void setEntity(@MappingTarget CashRefill parentEntity) {
            this.parentEntity = parentEntity;
        }

        @AfterMapping
        public void establishRelation(@MappingTarget CashRefillOperation.CashRefillOperationBuilder childEntity) {
            childEntity.cashRefill(parentEntity);
        }
    }

}
