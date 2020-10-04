package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MoneyTransferCreationModel {

    private Long fromBankAccountId;
    private Long toBankAccountId;
    private Long amount;

}
