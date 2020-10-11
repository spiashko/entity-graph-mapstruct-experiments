package com.siarhei.jpaefficiencyexperiments.operation.event;

import com.siarhei.jpaefficiencyexperiments.operation.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OperationPreparedEvent {

    private final Operation operation;

}
