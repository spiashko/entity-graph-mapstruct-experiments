package com.siarhei.jpaefficiencyexperiments.operation;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OperationViewAModel {

    private UUID id;
    private UUID bankAccountId;
    private Long amount;
    private OperationSource operationSource;

}
