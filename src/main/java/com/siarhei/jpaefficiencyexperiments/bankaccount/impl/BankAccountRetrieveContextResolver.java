package com.siarhei.jpaefficiencyexperiments.bankaccount.impl;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewBModel;
import com.siarhei.jpaefficiencyexperiments.crudbase.AbstractRetrieveContextResolver;
import org.springframework.stereotype.Component;

@Component
class BankAccountRetrieveContextResolver extends AbstractRetrieveContextResolver<BankAccount> {

    BankAccountRetrieveContextResolver(BankAccountSearchMapper mapper) {
        putInMapping(BankAccountViewAModel.class, EntityGraphs.empty(), mapper::mapToViewA);
        putInMapping(BankAccountViewBModel.class, EntityGraphs.named("BankAccount.operations"), mapper::mapToViewB);
    }
}
