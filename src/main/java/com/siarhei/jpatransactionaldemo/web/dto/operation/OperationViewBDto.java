package com.siarhei.jpatransactionaldemo.web.dto.operation;

import com.siarhei.jpatransactionaldemo.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationViewBDto {

    private Long id;
    private BankAccountDto bankAccount;
    private Long amount;
    private OperationSource operationSource;

    @Getter
    @Setter
    public static class BankAccountDto {

        private Long id;
        private Long balance;

    }

}
