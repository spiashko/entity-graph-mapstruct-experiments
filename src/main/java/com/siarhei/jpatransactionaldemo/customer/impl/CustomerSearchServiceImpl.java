package com.siarhei.jpatransactionaldemo.customer.impl;

import com.siarhei.jpatransactionaldemo.crudbase.BaseSearchServiceImpl;
import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerFilter;
import com.siarhei.jpatransactionaldemo.customer.CustomerSearchService;
import org.springframework.stereotype.Service;

@Service
public class CustomerSearchServiceImpl
        extends BaseSearchServiceImpl<Customer, CustomerFilter, CustomerSpec, CustomerRepository>
        implements CustomerSearchService {

    protected CustomerSearchServiceImpl(CustomerRepository repository, CustomerSpec spec) {
        super(repository, spec);
    }
}
