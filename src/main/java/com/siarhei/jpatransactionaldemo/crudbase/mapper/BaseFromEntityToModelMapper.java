package com.siarhei.jpatransactionaldemo.crudbase.mapper;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.crudbase.model.BaseJournalModel;

public interface BaseFromEntityToModelMapper<E extends BaseJournalEntity, R extends BaseJournalModel> {

    R map(E entity);

}
