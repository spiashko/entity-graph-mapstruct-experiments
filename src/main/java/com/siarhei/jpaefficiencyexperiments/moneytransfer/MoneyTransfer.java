package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpaefficiencyexperiments.operation.ReceiveMoneyTransferOperation;
import com.siarhei.jpaefficiencyexperiments.operation.SendMoneyTransferOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(name = "amount")
    private Long amount;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fk_send_operation", updatable = false)
    private SendMoneyTransferOperation sendOperation;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fk_receive_operation", updatable = false)
    private ReceiveMoneyTransferOperation receiveOperation;

    public void setSendOperation(SendMoneyTransferOperation sendOperation) {
        this.sendOperation = sendOperation;
        sendOperation.setSendMoneyTransfer(this);
    }

    public void setReceiveOperation(ReceiveMoneyTransferOperation receiveOperation) {
        this.receiveOperation = receiveOperation;
        receiveOperation.setReceiveMoneyTransfer(this);
    }
}
