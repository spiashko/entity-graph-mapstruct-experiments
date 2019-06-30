package com.siarhei.jpatransactionaldemo.customer.impl;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {

        if (customer.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be null");
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("customer with id=%d not found", id)));
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Long id) {

        customerRepository.deleteById(id);
    }

    @Override
    public void updateBalance(Long id, Long newBalance) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("customer with id=%d not found", id)));

        customer.setBalance(newBalance);

        customerRepository.save(customer);
    }
}
