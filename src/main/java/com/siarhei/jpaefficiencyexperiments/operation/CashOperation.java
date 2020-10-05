package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.cash.CashAction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class CashOperation<T extends CashAction<?>> extends Operation {

    public CashOperation(BankAccount bankAccount, Long amount) {
        super(bankAccount, amount);
    }

    public abstract T getCashAction();

}
