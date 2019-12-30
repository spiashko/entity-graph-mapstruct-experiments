package com.siarhei.jpatransactionaldemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransferDto {

    private Long id;
    private Long fromCustomerId;
    private Long toCustomerId;
    private Long amount;

}
