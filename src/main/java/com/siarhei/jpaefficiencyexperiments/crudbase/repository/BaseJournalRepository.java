package com.siarhei.jpaefficiencyexperiments.crudbase.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseJournalRepository<T extends BaseJournalEntity>
        extends EntityGraphJpaRepository<T, UUID>, EntityGraphJpaSpecificationExecutor<T> {
}
