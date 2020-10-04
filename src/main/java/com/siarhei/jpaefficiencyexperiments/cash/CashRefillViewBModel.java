package com.siarhei.jpaefficiencyexperiments.cash;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class CashRefillViewBModel extends BaseCashActionViewBModel {

    private CashActionOperationModel cashRefillOperation;

}
