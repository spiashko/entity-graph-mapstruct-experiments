package com.siarhei.jpatransactionaldemo.customer.impl;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
