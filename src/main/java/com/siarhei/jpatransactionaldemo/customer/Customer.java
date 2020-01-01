package com.siarhei.jpatransactionaldemo.customer;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends BaseJournalEntity {

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "balance")
    private Long balance;

    @OneToMany(mappedBy = "fromCustomer")
    private List<MoneyTransfer> outMoneyTransfers;

    @OneToMany(mappedBy = "toCustomer")
    private List<MoneyTransfer> inMoneyTransfers;

}
