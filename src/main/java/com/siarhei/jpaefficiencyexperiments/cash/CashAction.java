package com.siarhei.jpaefficiencyexperiments.cash;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpaefficiencyexperiments.operation.CashOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cash_action")
@DiscriminatorColumn(name = "action_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CashAction<T extends CashOperation<?>> extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(name = "cash_amount")
    private Long cashAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", insertable = false, updatable = false)
    private ActionType actionType;

    public abstract T getCashOperation();

}
