package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.cash.CashRefill;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawal;
import com.siarhei.jpatransactionaldemo.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummary;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation_source")
@NamedEntityGraph(
        name = "Operation.bankAccount",
        attributeNodes = @NamedAttributeNode("bankAccount")
)
@NamedEntityGraph(
        name = "Operation.all",
        attributeNodes = {
                @NamedAttributeNode("bankAccount"),
                @NamedAttributeNode("sendMoneyTransfer"),
                @NamedAttributeNode("receiveMoneyTransfer"),
                @NamedAttributeNode("cashWithdrawal"),
                @NamedAttributeNode("cashRefill"),
        }
)
public class Operation extends BaseJournalEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_bank_account")
    private BankAccount bankAccount;

    @NotNull
    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_source", insertable = false, updatable = false)
    private OperationSource operationSource;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cash_refill", insertable = false, updatable = false)
    private CashRefill cashRefill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cash_withdrawal", insertable = false, updatable = false)
    private CashWithdrawal cashWithdrawal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_money_transfer", insertable = false, updatable = false)
    @Where(clause = "fk_money_transfer = id and operation_source = 'SEND_MONEY_TRANSFER'") // not working
    private MoneyTransferSummary sendMoneyTransfer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_money_transfer", insertable = false, updatable = false)
    @Where(clause = "operation_source = 'RECEIVE_MONEY_TRANSFER'") // not working
    private MoneyTransferSummary receiveMoneyTransfer;

    public Operation(BankAccount bankAccount, @NotNull Long amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public enum OperationSource {
        //in
        RECEIVE_MONEY_TRANSFER,
        CASH_REFILL,

        //out
        SEND_MONEY_TRANSFER,
        CASH_WITHDRAWAL,
    }
}
