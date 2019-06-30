package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "money_transfer")
public class MoneyTransfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_from_customer")
    private Customer fromCustomer;

    @ManyToOne
    @JoinColumn(name = "fk_to_customer")
    private Customer toCustomer;

    @NotNull
    @Column(name = "amount")
    private Long amount;

}
