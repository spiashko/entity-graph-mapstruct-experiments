package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.cash.CashRefill;
import com.siarhei.jpaefficiencyexperiments.cash.CashWithdrawal;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operation")
@NamedEntityGraph(
        name = "Operation.viewc",
        attributeNodes = {
                @NamedAttributeNode("bankAccount"),
                @NamedAttributeNode("cashRefill"),
                @NamedAttributeNode("cashWithdrawal"),
                @NamedAttributeNode("receiveMoneyTransfer"),
                @NamedAttributeNode("sendMoneyTransfer"),
        }
)
@Immutable
public class OperationViewC extends BaseOperationEntity {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cashRefillOperation")
    private CashRefill cashRefill;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cashWithdrawalOperation")
    private CashWithdrawal cashWithdrawal;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "receiveOperation")
    private MoneyTransfer receiveMoneyTransfer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sendOperation")
    private MoneyTransfer sendMoneyTransfer;

}
