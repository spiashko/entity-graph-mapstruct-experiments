package com.siarhei.jpaefficiencyexperiments.crudbase.mapper;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;

public interface FromEntityMapper<E extends BaseJournalEntity> {

    <T> T map(E entity, Class<T> clazz) throws RequestedClassNotSupportedException;

}
