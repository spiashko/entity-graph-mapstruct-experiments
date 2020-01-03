package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_from_customer")
    private BankAccount fromBankAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_to_customer")
    private BankAccount toBankAccount;

    @NotNull
    @Column(name = "amount")
    private Long amount;

}
