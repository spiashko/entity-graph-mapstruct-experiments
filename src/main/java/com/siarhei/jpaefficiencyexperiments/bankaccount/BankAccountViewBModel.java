package com.siarhei.jpaefficiencyexperiments.bankaccount;

import com.siarhei.jpaefficiencyexperiments.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BankAccountViewBModel {

    private UUID id;
    private Long balance;
    private List<OperationModel> operations;

    @Getter
    @Setter
    public static class OperationModel {

        private UUID id;
        private Long amount;
        private OperationSource operationSource;

    }
}
