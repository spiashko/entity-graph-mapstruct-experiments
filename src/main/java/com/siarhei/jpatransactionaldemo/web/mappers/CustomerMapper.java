package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.web.dto.customer.CreateCustomerDto;
import com.siarhei.jpatransactionaldemo.web.dto.customer.RetrieveCustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    RetrieveCustomerDto map(Customer customer);

    Customer map(CreateCustomerDto customer);

}
