package com.siarhei.jpaefficiencyexperiments.operation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationViewBModel {

    private Long id;
    private BankAccountModel bankAccount;
    private Long amount;
    private OperationSource operationSource;

    @Getter
    @Setter
    public static class BankAccountModel {

        private Long id;
        private Long balance;

    }

}
