package com.siarhei.jpaefficiencyexperiments.cash;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Setter
@Getter
public abstract class BaseCashActionViewBModel {

    private UUID id;
    private UUID bankAccountId;
    private Long cashAmount;

    @Setter
    @Getter
    public static class CashActionOperationModel {

        private UUID id;
        private UUID bankAccountId;
        private Long amount;

    }

}
