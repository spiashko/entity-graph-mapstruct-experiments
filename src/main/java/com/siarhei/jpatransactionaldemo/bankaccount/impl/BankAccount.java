package com.siarhei.jpatransactionaldemo.bankaccount.impl;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.moneytransfer.impl.MoneyTransfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseJournalEntity {

    @NotNull
    @Column(name = "balance")
    private Long balance;

    @OneToMany(mappedBy = "fromBankAccount")
    private List<MoneyTransfer> outMoneyTransfers;

    @OneToMany(mappedBy = "toBankAccount")
    private List<MoneyTransfer> inMoneyTransfers;

}
