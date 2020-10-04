package com.siarhei.jpaefficiencyexperiments.crudbase.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public abstract class BaseJournalEntity extends BaseEntity {

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @NotNull
    @CreatedBy
    @Column(name = "created_by")
    private UUID createdBy;

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;

    @NotNull
    @LastModifiedBy
    @Column(name = "updated_by")
    private UUID updatedBy;

}
