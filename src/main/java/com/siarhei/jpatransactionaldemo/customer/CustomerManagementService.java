package com.siarhei.jpatransactionaldemo.customer;

public interface CustomerManagementService {

    Customer createCustomer(Customer customer);

    void deleteCustomerById(Long id);

    void addToBalance(Long id, Long amount);

    void subtractFromBalance(Long id, Long amount);

}
