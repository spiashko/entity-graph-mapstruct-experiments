package com.siarhei.jpaefficiencyexperiments.operation;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OperationViewBModel {

    private UUID id;
    private BankAccountModel bankAccount;
    private Long amount;
    private OperationSource operationSource;

    @Getter
    @Setter
    public static class BankAccountModel {

        private UUID id;
        private Long balance;

    }

}
