package com.siarhei.jpaefficiencyexperiments.cash;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class CashWithdrawalViewBModel extends BaseCashActionViewBModel {

    private Long includedFee;
    private CashActionOperationModel cashRefillOperation;

}
