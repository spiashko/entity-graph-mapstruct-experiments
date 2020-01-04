package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation_type")
public class Operation extends BaseJournalEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bank_account")
    private BankAccount bankAccount;

    @NotNull
    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", insertable = false, updatable = false)
    private OperationType operationType;

    public enum OperationType {
        IN,
        OUT
    }
}
