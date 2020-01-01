package com.siarhei.jpatransactionaldemo.customer.impl;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerManagementService;
import com.siarhei.jpatransactionaldemo.customer.CustomerSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {

    private final CustomerRepository customerRepository;
    private final CustomerSearchService customerSearchService;

    @Override
    public Customer createCustomer(Customer customer) {

        if (customer.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be null");
        }

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {

        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addToBalance(Long id, Long amount) {
        Customer customer = customerSearchService.findOneOrThrow(id);
        customer.setBalance(customer.getBalance() + amount);
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void subtractFromBalance(Long id, Long amount) {
        Customer customer = customerSearchService.findOneOrThrow(id);
        customer.setBalance(customer.getBalance() - amount);
        customerRepository.save(customer);
    }
}
