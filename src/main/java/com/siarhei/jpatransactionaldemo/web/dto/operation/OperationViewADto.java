package com.siarhei.jpatransactionaldemo.web.dto.operation;

import com.siarhei.jpatransactionaldemo.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationViewADto {

    private Long bankAccountId;
    private Long amount;
    private OperationSource operationSource;

}
