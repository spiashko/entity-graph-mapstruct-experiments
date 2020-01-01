package com.siarhei.jpatransactionaldemo.web.rest;

import com.siarhei.jpatransactionaldemo.customer.Customer;
import com.siarhei.jpatransactionaldemo.customer.CustomerFilter;
import com.siarhei.jpatransactionaldemo.customer.CustomerManagementService;
import com.siarhei.jpatransactionaldemo.customer.CustomerSearchService;
import com.siarhei.jpatransactionaldemo.web.dto.customer.CreateCustomerDto;
import com.siarhei.jpatransactionaldemo.web.dto.customer.RetrieveCustomerDto;
import com.siarhei.jpatransactionaldemo.web.mappers.CustomerMapper;
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

    private final CustomerManagementService customerManagementService;
    private final CustomerSearchService customerSearchService;
    private final CustomerMapper customerMapper;

    @PostMapping("/customers")
    public ResponseEntity<RetrieveCustomerDto> createCustomer(@RequestBody CreateCustomerDto customerDto) throws URISyntaxException {
        Customer customer = customerMapper.map(customerDto);
        Customer result = customerManagementService.createCustomer(customer);
        RetrieveCustomerDto resultDto = customerMapper.map(customer);
        return ResponseEntity.created(new URI("/customers/" + result.getId()))
                .body(resultDto);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<RetrieveCustomerDto>> getAllCustomers(CustomerFilter customerFilter) {
        List<Customer> customers = customerSearchService.findAll(customerFilter);
        return ResponseEntity.ok(customers.stream()
                .map(customerMapper::map)
                .collect(Collectors.toList()));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<RetrieveCustomerDto> getCustomer(@PathVariable Long id) {
        Customer customer = customerSearchService.findOneOrThrow(id);
        RetrieveCustomerDto result = customerMapper.map(customer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerManagementService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }

}
