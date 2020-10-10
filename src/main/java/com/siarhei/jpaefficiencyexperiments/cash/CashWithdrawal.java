package com.siarhei.jpaefficiencyexperiments.cash;

import com.siarhei.jpaefficiencyexperiments.operation.CashWithdrawalOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("WITHDRAWAL")
@NamedEntityGraph(
        name = "CashWithdrawal.operation",
        attributeNodes = @NamedAttributeNode("cashWithdrawalOperation")
)
public class CashWithdrawal extends CashAction<CashWithdrawalOperation> {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fk_withdrawal_operation", updatable = false)
    private CashWithdrawalOperation cashWithdrawalOperation;

    @NotNull
    @Column(name = "withdrawal_fee")
    private Long fee;

    @Override
    public CashWithdrawalOperation getCashOperation() {
        return cashWithdrawalOperation;
    }
}
