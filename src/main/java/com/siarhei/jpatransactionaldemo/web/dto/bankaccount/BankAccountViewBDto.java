package com.siarhei.jpatransactionaldemo.web.dto.bankaccount;

import com.siarhei.jpatransactionaldemo.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountViewBDto {

    private Long id;
    private Long balance;
    private List<OperationDto> operations;

    @Getter
    @Setter
    public static class OperationDto {

        private Long amount;
        private OperationSource operationSource;

    }
}
