package com.siarhei.jpaefficiencyexperiments.cash;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cash_action")
@DiscriminatorColumn(name = "action_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CashAction extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "cash_amount")
    private Long cashAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", insertable = false, updatable = false)
    private ActionType actionType;

}
