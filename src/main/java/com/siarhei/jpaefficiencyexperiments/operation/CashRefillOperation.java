package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("CASH_REFILL")
public class CashRefillOperation extends CashOperation<CashRefill> implements InOperation {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cashRefillOperation", optional = false)
    private CashRefill cashRefill;

    @Builder
    public CashRefillOperation(BankAccount bankAccount, Long amount, CashRefill cashRefill) {
        super(bankAccount, amount);
        this.cashRefill = cashRefill;
    }

    @Override
    public CashRefill getCashAction() {
        return this.cashRefill;
    }

}
