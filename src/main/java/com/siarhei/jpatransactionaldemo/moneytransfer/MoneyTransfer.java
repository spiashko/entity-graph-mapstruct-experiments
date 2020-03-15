package com.siarhei.jpatransactionaldemo.moneytransfer;

import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpatransactionaldemo.operation.SendMoneyTransferOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
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
        name = "MoneyTransfer.all",
        attributeNodes = {
                @NamedAttributeNode(value = "sendOperation", subgraph = "Operation.bankAccount"),
                @NamedAttributeNode(value = "receiveOperation", subgraph = "Operation.bankAccount"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "Operation.bankAccount",
                        attributeNodes = @NamedAttributeNode("bankAccount")
                )
        }
)
public class MoneyTransfer extends BaseJournalEntity {

    @NotNull
    @Column(name = "amount")
    private Long amount;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_send_operation", updatable = false)
    private SendMoneyTransferOperation sendOperation;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_receive_operation", updatable = false)
    private ReceiveMoneyTransferOperation receiveOperation;

}
