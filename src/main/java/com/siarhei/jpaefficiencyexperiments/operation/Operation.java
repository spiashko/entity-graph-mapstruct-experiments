package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.operation.event.OperationPreparedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation_source")
public abstract class Operation extends BaseOperationEntity {

    public Operation(BankAccount bankAccount, Long amount) {
        super(bankAccount, amount);
    }

    @PrePersist
    public void prePersist() {
        registerEvent(new OperationPreparedEvent(this));
    }
}
