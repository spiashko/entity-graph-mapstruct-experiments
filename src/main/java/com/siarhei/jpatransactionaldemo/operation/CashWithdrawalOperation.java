package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@DiscriminatorValue("CASH_WITHDRAWAL")
public class CashWithdrawalOperation extends OutOperation {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cash_withdrawal")
    private CashWithdrawal cashWithdrawal;

    @Builder
    public CashWithdrawalOperation(BankAccount bankAccount, @NotNull Long amount, CashWithdrawal cashWithdrawal) {
        super(bankAccount, amount);
        this.cashWithdrawal = cashWithdrawal;
    }

}
