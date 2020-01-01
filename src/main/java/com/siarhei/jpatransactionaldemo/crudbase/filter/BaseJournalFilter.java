package com.siarhei.jpatransactionaldemo.crudbase.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public abstract class BaseJournalFilter extends BaseFilter {

    private Instant createdFromInstant;
    private Instant createdToInstant;
    private List<Long> createdBy;
    private Instant updatedFromInstant;
    private Instant updatedToInstant;
    private List<Long> updatedBy;

}
