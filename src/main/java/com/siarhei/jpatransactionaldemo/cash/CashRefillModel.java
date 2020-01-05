package com.siarhei.jpatransactionaldemo.cash;

import com.siarhei.jpatransactionaldemo.operation.impl.CashRefillOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashRefillModel extends CashActionModel {

    private CashRefillOperation cashRefillOperation;

}
