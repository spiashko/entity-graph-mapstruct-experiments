package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
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
@DiscriminatorValue("SEND_MONEY_TRANSFER")
public class SendMoneyTransferOperation extends OutOperation {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_send_money_transfer")
    private MoneyTransferFull moneyTransfer;

    @Builder
    public SendMoneyTransferOperation(BankAccount bankAccount, @NotNull Long amount, MoneyTransferFull moneyTransfer) {
        super(bankAccount, amount);
        this.moneyTransfer = moneyTransfer;
    }

}
