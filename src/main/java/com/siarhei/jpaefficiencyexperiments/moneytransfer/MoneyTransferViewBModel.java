package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MoneyTransferViewBModel {

    private UUID id;
    private Long fromBankAccountId;
    private Long toBankAccountId;
    private Long amount;

}
