package com.siarhei.jpaefficiencyexperiments.bankaccount;

import com.siarhei.jpaefficiencyexperiments.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountViewBModel {

    private Long id;
    private Long balance;
    private List<OperationModel> operations;

    @Getter
    @Setter
    public static class OperationModel {

        private Long amount;
        private OperationSource operationSource;

    }
}
