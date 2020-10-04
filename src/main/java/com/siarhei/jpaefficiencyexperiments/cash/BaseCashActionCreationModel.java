package com.siarhei.jpaefficiencyexperiments.cash;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Setter
@Getter
public abstract class BaseCashActionCreationModel {

    private UUID bankAccountId;
    private Long cashAmount;

}
