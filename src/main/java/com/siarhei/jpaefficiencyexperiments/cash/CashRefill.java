package com.siarhei.jpaefficiencyexperiments.cash;

import com.siarhei.jpaefficiencyexperiments.operation.CashRefillOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("REFILL")
public class CashRefill extends CashAction {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_refill_operation", updatable = false)
    private CashRefillOperation cashRefillOperation;

    public void setCashRefillOperation(CashRefillOperation cashRefillOperation) {
        cashRefillOperation.setCashRefill(this);
        this.cashRefillOperation = cashRefillOperation;
    }
}
