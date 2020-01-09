package com.siarhei.jpatransactionaldemo.moneytransfer.full;

import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransfer;
import com.siarhei.jpatransactionaldemo.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.SendMoneyTransferOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "money_transfer")
@NamedEntityGraph(
        name = "MoneyTransferFull.all",
        attributeNodes = {
                @NamedAttributeNode("sendOperation"),
                @NamedAttributeNode("receiveOperation"),
        }
)
public class MoneyTransferFull extends BaseMoneyTransfer {

    @NotNull
    @OneToOne(mappedBy = "moneyTransfer", cascade = CascadeType.ALL, optional = false)
    private SendMoneyTransferOperation sendOperation;

    @NotNull
    @OneToOne(mappedBy = "moneyTransfer", cascade = CascadeType.ALL, optional = false)
    private ReceiveMoneyTransferOperation receiveOperation;

}
