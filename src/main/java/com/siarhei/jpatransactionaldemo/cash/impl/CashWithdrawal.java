package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.operation.impl.CashWithdrawalOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("WITHDRAWAL")
public class CashWithdrawal extends CashAction {

    @OneToOne(mappedBy = "cashWithdrawal", cascade = CascadeType.ALL)
    private CashWithdrawalOperation cashWithdrawalOperation;

}
