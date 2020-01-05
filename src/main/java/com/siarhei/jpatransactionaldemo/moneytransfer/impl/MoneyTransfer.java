package com.siarhei.jpatransactionaldemo.moneytransfer.impl;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.bankaccount.impl.BankAccount;
import com.siarhei.jpatransactionaldemo.operation.impl.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.impl.SendMoneyTransferOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "money_transfer")
public class MoneyTransfer extends BaseJournalEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_send_operation")
    private SendMoneyTransferOperation sendOperation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_receive_operation")
    private ReceiveMoneyTransferOperation receiveOperation;

    @NotNull
    @Column(name = "amount")
    private Long amount;

}
