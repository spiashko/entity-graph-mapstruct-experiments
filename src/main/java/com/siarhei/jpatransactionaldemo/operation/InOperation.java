package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class InOperation extends Operation {

    public InOperation(BankAccount bankAccount, @NotNull Long amount) {
        super(bankAccount, amount);
    }
}
