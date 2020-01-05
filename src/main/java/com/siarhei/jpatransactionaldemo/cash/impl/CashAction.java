package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.ActionType;
import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cash_action")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CashAction extends BaseJournalEntity {

    @NotNull
    @Column(name = "cash_amount")
    private Long cashAmount;

    @NotNull
    @Column(name = "fee")
    private Long fee;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_source", insertable = false, updatable = false)
    private ActionType actionType;

}
