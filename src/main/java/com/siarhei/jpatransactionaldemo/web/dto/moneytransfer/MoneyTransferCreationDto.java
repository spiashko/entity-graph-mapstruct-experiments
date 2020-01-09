package com.siarhei.jpatransactionaldemo.web.dto.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransferCreationDto {

    private Long fromBankAccountId;
    private Long toBankAccountId;
    private Long amount;

}
