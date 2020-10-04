package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseOperationEntity extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_bank_account")
    private BankAccount bankAccount;
    @NotNull
    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_source", insertable = false, updatable = false)
    private OperationSource operationSource;

    public BaseOperationEntity(BankAccount bankAccount, @NotNull Long amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

}
