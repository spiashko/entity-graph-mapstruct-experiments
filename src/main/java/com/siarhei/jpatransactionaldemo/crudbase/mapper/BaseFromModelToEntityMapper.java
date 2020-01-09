package com.siarhei.jpatransactionaldemo.crudbase.mapper;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;

public interface BaseFromModelToEntityMapper<E extends BaseJournalEntity, C> {

    E map(C creationModel);

}
