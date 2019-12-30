package com.siarhei.jpatransactionaldemo.customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getCustomers();

    void deleteCustomerById(Long id);

    void updateBalance(Long id, Long newBalance);

}
