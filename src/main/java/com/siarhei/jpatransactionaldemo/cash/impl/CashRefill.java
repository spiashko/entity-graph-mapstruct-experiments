package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.operation.impl.CashRefillOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("REFILL")
public class CashRefill extends CashAction {

    @OneToOne(mappedBy = "cashRefill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CashRefillOperation cashRefillOperation;

    public void setCashRefillOperation(CashRefillOperation cashRefillOperation) {
        cashRefillOperation.setCashRefill(this);
        this.cashRefillOperation = cashRefillOperation;
    }
}
