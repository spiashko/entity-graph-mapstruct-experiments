package com.siarhei.jpaefficiencyexperiments.crudbase;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpaefficiencyexperiments.crudbase.exception.RequestedClassNotSupportedException;

public interface RetrieveContextResolver<E extends BaseJournalEntity> {

    <T> RetrieveContext<E, T> resolve(Class<T> clazz) throws RequestedClassNotSupportedException;

}
