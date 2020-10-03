package com.siarhei.jpaefficiencyexperiments.crudbase.mapper;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;

public interface BaseFromModelToEntityMapper<E extends BaseJournalEntity, C> {

    E map(C creationModel);

}
