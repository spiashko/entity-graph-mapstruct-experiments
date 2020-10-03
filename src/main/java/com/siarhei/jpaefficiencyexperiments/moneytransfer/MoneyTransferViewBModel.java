package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransferViewBModel {

    private Long id;
    private Long fromBankAccountId;
    private Long toBankAccountId;
    private Long amount;

}
