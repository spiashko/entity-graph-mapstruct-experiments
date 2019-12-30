package com.siarhei.jpatransactionaldemo.customer;

import com.siarhei.jpatransactionaldemo.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto map(Customer customer);

}
