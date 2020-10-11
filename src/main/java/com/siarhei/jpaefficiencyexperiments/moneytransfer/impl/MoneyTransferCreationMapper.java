package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.crudbase.mapperconfig.CreationMapperMappingConfig;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpaefficiencyexperiments.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpaefficiencyexperiments.operation.SendMoneyTransferOperation;
import org.mapstruct.*;

import javax.persistence.EntityManager;

@Mapper(config = CreationMapperMappingConfig.class)
interface MoneyTransferCreationMapper {

    @Mapping(target = "sendOperation.bankAccount", source = "fromBankAccountId")
    @Mapping(target = "sendOperation.amount", source = "amount")
    @Mapping(target = "receiveOperation.bankAccount", source = "toBankAccountId")
    @Mapping(target = "receiveOperation.amount", source = "amount")
    MoneyTransfer map(MoneyTransferCreationModel creationModel, @Context EntityManager entityManager,
                      @Context BiDirectionalReferences references);

    default MoneyTransfer map(MoneyTransferCreationModel creationModel, @Context EntityManager entityManager) {
        return map(creationModel, entityManager, new BiDirectionalReferences());
    }

    class BiDirectionalReferences {

        private MoneyTransfer parentEntity;

        @BeforeMapping
        public void setEntity(@MappingTarget MoneyTransfer parentEntity) {
            this.parentEntity = parentEntity;
        }

        @AfterMapping
        public void establishRelation(@MappingTarget SendMoneyTransferOperation.SendMoneyTransferOperationBuilder childEntity) {
            childEntity.sendMoneyTransfer(parentEntity);
        }

        @AfterMapping
        public void establishRelation(@MappingTarget ReceiveMoneyTransferOperation.ReceiveMoneyTransferOperationBuilder childEntity) {
            childEntity.receiveMoneyTransfer(parentEntity);
        }
    }

}
