package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccount;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
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
@DiscriminatorValue("CASH_WITHDRAWAL")
public class CashWithdrawalOperation extends CashOperation<CashWithdrawal> implements OutOperation {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cashWithdrawalOperation", optional = false)
    private CashWithdrawal cashWithdrawal;

    @Builder
    public CashWithdrawalOperation(BankAccount bankAccount, Long amount, CashWithdrawal cashWithdrawal) {
        super(bankAccount, amount);
        this.cashWithdrawal = cashWithdrawal;
    }

    @Override
    public CashWithdrawal getCashAction() {
        return this.cashWithdrawal;
    }

}
