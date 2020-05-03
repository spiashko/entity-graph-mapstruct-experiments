package com.siarhei.jpatransactionaldemo.bankaccount.view;

import com.siarhei.jpatransactionaldemo.operation.OperationSource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountViewBBean {

    private Long id;
    private Long balance;
    private List<OperationView> operations;

    @Getter
    @Setter
    public static class OperationView {

        private Long amount;
        private OperationSource operationSource;

    }
}
