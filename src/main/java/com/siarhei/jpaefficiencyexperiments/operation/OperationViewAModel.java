package com.siarhei.jpaefficiencyexperiments.operation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationViewAModel {

    private Long id;
    private Long bankAccountId;
    private Long amount;
    private OperationSource operationSource;

}
