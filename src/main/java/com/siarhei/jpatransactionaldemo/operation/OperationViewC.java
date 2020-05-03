package com.siarhei.jpatransactionaldemo.operation;

import com.siarhei.jpatransactionaldemo.cash.CashRefill;
import com.siarhei.jpatransactionaldemo.cash.CashWithdrawal;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operation")
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
