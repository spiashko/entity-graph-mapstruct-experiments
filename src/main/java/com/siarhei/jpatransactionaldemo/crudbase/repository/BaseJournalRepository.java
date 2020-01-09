package com.siarhei.jpatransactionaldemo.crudbase.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJournalRepository<T extends BaseJournalEntity>
        extends EntityGraphJpaRepository<T, Long>, EntityGraphJpaSpecificationExecutor<T> {
}
