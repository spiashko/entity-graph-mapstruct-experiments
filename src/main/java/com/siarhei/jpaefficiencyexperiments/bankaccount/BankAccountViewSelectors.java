package com.siarhei.jpaefficiencyexperiments.bankaccount;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.crudbase.ViewSelector;

public class BankAccountViewSelectors {

    public static BAViewSelector<BankAccountViewAModel> viewA =
            new BAViewSelector<>(null, BankAccountViewAModel.class);

    public static BAViewSelector<BankAccountViewBModel> viewB =
            new BAViewSelector<>(EntityGraphs.named("BankAccount.operations"), BankAccountViewBModel.class);

    private static class BAViewSelector<T> extends ViewSelector<T> {

        private BAViewSelector(EntityGraph entityGraph, Class<T> clazz) {
            super(entityGraph, clazz);
        }
    }
}
