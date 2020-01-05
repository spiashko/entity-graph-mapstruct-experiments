package com.siarhei.jpatransactionaldemo.crudbase.model;

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
import java.time.Instant;

@Getter
@Setter
public class BaseJournalModel extends BaseModel {

    private Instant createdAt;
    private Long createdBy;
    private Instant updatedAt;
    private Long updatedBy;

}
