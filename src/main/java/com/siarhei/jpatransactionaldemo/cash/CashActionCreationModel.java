package com.siarhei.jpatransactionaldemo.cash;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class CashActionCreationModel {

    private Long bankAccountId;
    private Long cashAmount;
    private Long fee;

}
