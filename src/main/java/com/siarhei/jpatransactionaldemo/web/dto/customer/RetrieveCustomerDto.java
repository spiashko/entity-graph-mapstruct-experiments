package com.siarhei.jpatransactionaldemo.web.dto.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetrieveCustomerDto {

    private Long id;
    private String name;
    private Long balance;

}
