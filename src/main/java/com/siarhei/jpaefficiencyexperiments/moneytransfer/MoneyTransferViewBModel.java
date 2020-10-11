package com.siarhei.jpaefficiencyexperiments.moneytransfer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MoneyTransferViewBModel {

    private UUID id;
    private OperationModel sendOperation;
    private OperationModel receiveOperation;
    private Long amount;

    @Setter
    @Getter
    public static class OperationModel {

        private UUID id;
        private UUID bankAccountId;
        private Long amount;

    }

}
