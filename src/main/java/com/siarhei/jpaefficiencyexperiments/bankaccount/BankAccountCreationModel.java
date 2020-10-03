package com.siarhei.jpaefficiencyexperiments.bankaccount;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BankAccountCreationModel {

    private Long balance;

}
