package com.siarhei.jpatransactionaldemo.cash;

import com.siarhei.jpatransactionaldemo.operation.impl.CashWithdrawalOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashWithdrawalModel extends CashActionModel {

    private CashWithdrawalOperation cashWithdrawalOperation;

}
