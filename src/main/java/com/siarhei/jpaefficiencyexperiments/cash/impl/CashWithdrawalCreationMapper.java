package com.siarhei.jpaefficiencyexperiments.cash.impl;

import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawalCreationModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.ToEntityMapperSupport;
import com.siarhei.jpaefficiencyexperiments.operation.CashWithdrawalOperation;
import org.mapstruct.*;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.ERROR)
interface CashWithdrawalCreationMapper extends ToEntityMapperSupport {

    @Mapping(target = "cashWithdrawalOperation.bankAccount", source = "bankAccountId")
    @Mapping(target = "cashWithdrawalOperation.amount", source = "cashAmount")
    CashWithdrawal map(CashWithdrawalCreationModel creationModel, @Context EntityManager entityManager,
                       @Context BiDirectionalReferences references);

    default CashWithdrawal map(CashWithdrawalCreationModel creationModel, @Context EntityManager entityManager) {
        return map(creationModel, entityManager, new BiDirectionalReferences());
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
