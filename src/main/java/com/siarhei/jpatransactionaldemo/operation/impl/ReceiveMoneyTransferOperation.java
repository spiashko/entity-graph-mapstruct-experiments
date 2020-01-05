package com.siarhei.jpatransactionaldemo.operation.impl;

import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccount;
import com.siarhei.jpatransactionaldemo.moneytransfer.impl.MoneyTransfer;
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
@DiscriminatorValue("RECEIVE_MONEY_TRANSFER")
public class ReceiveMoneyTransferOperation extends InOperation {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_operation_source")
    private MoneyTransfer moneyTransfer;

    @Builder
    public ReceiveMoneyTransferOperation(BankAccount bankAccount, @NotNull Long amount, MoneyTransfer moneyTransfer) {
        super(bankAccount, amount);
        this.moneyTransfer = moneyTransfer;
    }

}
