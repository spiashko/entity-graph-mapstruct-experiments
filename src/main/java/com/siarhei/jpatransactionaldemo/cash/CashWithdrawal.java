package com.siarhei.jpatransactionaldemo.cash;

import com.siarhei.jpatransactionaldemo.operation.CashWithdrawalOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("WITHDRAWAL")
public class CashWithdrawal extends CashAction {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_withdrawal_operation", updatable = false)
    private CashWithdrawalOperation cashWithdrawalOperation;

    @NotNull
    @Column(name = "included_fee")
    private Long includedFee;

    public void setCashWithdrawalOperation(CashWithdrawalOperation cashWithdrawalOperation) {
        cashWithdrawalOperation.setCashWithdrawal(this);
        this.cashWithdrawalOperation = cashWithdrawalOperation;
    }

}
