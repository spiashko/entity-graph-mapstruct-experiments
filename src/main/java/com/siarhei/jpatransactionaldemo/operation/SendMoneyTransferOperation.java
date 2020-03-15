package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("SEND_MONEY_TRANSFER")
public class SendMoneyTransferOperation extends OutOperation {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sendOperation", optional = false)
    private MoneyTransfer sendMoneyTransfer;

    @Builder
    public SendMoneyTransferOperation(BankAccount bankAccount, @NotNull Long amount, MoneyTransfer sendMoneyTransfer) {
        super(bankAccount, amount);
        this.sendMoneyTransfer = sendMoneyTransfer;
    }

}
