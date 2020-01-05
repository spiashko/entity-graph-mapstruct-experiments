package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccount;
import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
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
@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation_source")
public class Operation extends BaseJournalEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bank_account")
    private BankAccount bankAccount;

    @NotNull
    @Column(name = "fk_bank_account")
    private Long bankAccountId;

    @NotNull
    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_source", insertable = false, updatable = false)
    private OperationSource operationSource;

    @Column(name = "fk_operation_source")
    private Long fkOperationSource;

    public Operation(BankAccount bankAccount, @NotNull Long amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public enum OperationSource {
        //in
        RECEIVE_MONEY_TRANSFER,
        CASH_REFILL,

        //out
        SEND_MONEY_TRANSFER,
        CASH_WITHDRAWAL,
    }
}
