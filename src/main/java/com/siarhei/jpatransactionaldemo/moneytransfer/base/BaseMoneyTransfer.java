package com.siarhei.jpatransactionaldemo.moneytransfer.base;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseMoneyTransfer extends BaseJournalEntity {

    @NotNull
    @Column(name = "amount")
    private Long amount;

}
