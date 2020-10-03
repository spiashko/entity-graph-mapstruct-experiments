package com.siarhei.jpaefficiencyexperiments.operation;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpaefficiencyexperiments.crudbase.ViewSelector;

public class OperationViewSelectors {

    public static OViewSelector<OperationViewAModel> viewA =
            new OViewSelector<>(null, OperationViewAModel.class);

    public static OViewSelector<OperationViewBModel> viewB =
            new OViewSelector<>(EntityGraphs.named("Operation.viewb"), OperationViewBModel.class);

    public static OViewSelector<OperationViewCModel> viewC =
            new OViewSelector<>(EntityGraphs.named("Operation.viewb"), OperationViewCModel.class);

    private static class OViewSelector<T> extends ViewSelector<T> {

        private OViewSelector(EntityGraph entityGraph, Class<T> clazz) {
            super(entityGraph, clazz);
        }
    }
}
