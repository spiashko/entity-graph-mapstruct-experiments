package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class MoneyTransferCreationModel {

    private UUID fromBankAccountId;
    private UUID toBankAccountId;
    private Long amount;

}
