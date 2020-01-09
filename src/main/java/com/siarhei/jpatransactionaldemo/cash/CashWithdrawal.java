package com.siarhei.jpatransactionaldemo.cash;

import com.siarhei.jpatransactionaldemo.operation.CashWithdrawalOperation;
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
@DiscriminatorValue("WITHDRAWAL")
public class CashWithdrawal extends CashAction {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cashWithdrawal")
    private CashWithdrawalOperation cashWithdrawalOperation;

    public void setCashRefillOperation(CashWithdrawalOperation cashWithdrawalOperation) {
        cashWithdrawalOperation.setCashWithdrawal(this);
        this.cashWithdrawalOperation = cashWithdrawalOperation;
    }

}
