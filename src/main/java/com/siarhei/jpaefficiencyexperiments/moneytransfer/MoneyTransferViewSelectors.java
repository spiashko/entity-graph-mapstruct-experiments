package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.crudbase.ViewSelector;

public class MoneyTransferViewSelectors {

    public static MTViewSelector<MoneyTransferViewAModel> viewA =
            new MTViewSelector<>(null, MoneyTransferViewAModel.class);

    public static MTViewSelector<MoneyTransferViewBModel> viewB =
            new MTViewSelector<>(EntityGraphs.named("MoneyTransfer.all"), MoneyTransferViewBModel.class);

    private static class MTViewSelector<T> extends ViewSelector<T> {

        private MTViewSelector(EntityGraph entityGraph, Class<T> clazz) {
            super(entityGraph, clazz);
        }
    }
}
