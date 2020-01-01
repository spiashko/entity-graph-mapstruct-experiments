package com.siarhei.jpatransactionaldemo.web.dto.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDto {

    private String name;
    private Long balance;

}
