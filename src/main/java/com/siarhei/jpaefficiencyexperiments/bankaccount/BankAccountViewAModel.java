package com.siarhei.jpaefficiencyexperiments.bankaccount;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BankAccountViewAModel {

    private UUID id;
    private Long balance;

}
