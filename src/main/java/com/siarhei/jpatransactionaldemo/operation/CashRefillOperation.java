package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.cash.CashRefill;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("CASH_REFILL")
public class CashRefillOperation extends InOperation {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cashRefillOperation", optional = false)
    private CashRefill cashRefill;

    @Builder
    public CashRefillOperation(BankAccount bankAccount, @NotNull Long amount, CashRefill cashRefill) {
        super(bankAccount, amount);
        this.cashRefill = cashRefill;
    }
}
