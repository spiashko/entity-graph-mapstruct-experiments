package com.siarhei.jpatransactionaldemo.web.dto.bankaccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetrieveBankAccountDto {

    private Long id;
    private String name;
    private Long balance;

}
