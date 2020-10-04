package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
@Getter
public class RetrieveContext<E extends BaseJournalEntity, T> {

    private final EntityGraph entityGraph;
    private final Function<E, T> mapper;

}
