package com.siarhei.jpatransactionaldemo.web.rest;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerMapper;
import com.siarhei.jpatransactionaldemo.customer.CustomerService;
import com.siarhei.jpatransactionaldemo.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class CustomerResource {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody Customer customer) throws URISyntaxException {
        Customer result = customerService.createCustomer(customer);
        return ResponseEntity.created(new URI("/customers/" + result.getId()))
                .body(customerMapper.map(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers.stream()
                .map(customerMapper::map)
                .collect(Collectors.toList()));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        CustomerDto result = customerMapper.map(customer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }

}
