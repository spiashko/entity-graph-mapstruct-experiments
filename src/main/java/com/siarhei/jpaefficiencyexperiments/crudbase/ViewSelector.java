package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import lombok.Getter;

@Getter
public abstract class ViewSelector<T> {

    private final EntityGraph entityGraph;
    private final Class<T> clazz;

    protected ViewSelector(EntityGraph entityGraph, Class<T> clazz) {
        this.entityGraph = entityGraph;
        this.clazz = clazz;
    }

}
