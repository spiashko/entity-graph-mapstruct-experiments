package com.siarhei.jpatransactionaldemo.crudbase.mapper;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;

public interface BaseEntityModelMapper<E extends BaseJournalEntity, R extends BaseJournalModel, C>
        extends BaseFromEntityToModelMapper<E, R>, BaseFromModelToEntityMapper<E, C> {
}
