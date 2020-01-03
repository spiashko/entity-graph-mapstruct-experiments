package com.siarhei.jpatransactionaldemo.web.dto.moneytransfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMoneyTransferDto {

    private Long fromBankAccountId;
    private Long toBankAccountId;
    private Long amount;

}
