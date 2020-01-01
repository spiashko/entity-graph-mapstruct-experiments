package com.siarhei.jpatransactionaldemo.crudbase.repository;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJournalRepository<T extends BaseJournalEntity>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
