package com.siarhei.jpatransactionaldemo.web.dto.bankaccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBankAccountDto {

    private String name;
    private Long balance;

}
