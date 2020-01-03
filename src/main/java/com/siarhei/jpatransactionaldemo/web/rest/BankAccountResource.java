package com.siarhei.jpatransactionaldemo.web.rest;

import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountFilter;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountManagementService;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.CreateBankAccountDto;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.RetrieveBankAccountDto;
import com.siarhei.jpatransactionaldemo.web.mappers.BankAccountMapper;
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
public class BankAccountResource {

    private final BankAccountManagementService customerManagementService;
    private final BankAccountSearchService customerSearchService;
    private final BankAccountMapper customerMapper;

    @PostMapping("/customers")
    public ResponseEntity<RetrieveBankAccountDto> createBankAccount(@RequestBody CreateBankAccountDto customerDto) throws URISyntaxException {
        BankAccount customer = customerMapper.map(customerDto);
        BankAccount result = customerManagementService.createBankAccount(customer);
        RetrieveBankAccountDto resultDto = customerMapper.map(customer);
        return ResponseEntity.created(new URI("/customers/" + result.getId()))
                .body(resultDto);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<RetrieveBankAccountDto>> getAllBankAccounts(BankAccountFilter customerFilter) {
        List<BankAccount> customers = customerSearchService.findAll(customerFilter);
        return ResponseEntity.ok(customers.stream()
                .map(customerMapper::map)
                .collect(Collectors.toList()));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<RetrieveBankAccountDto> getBankAccount(@PathVariable Long id) {
        BankAccount customer = customerSearchService.findOneOrThrow(id);
        RetrieveBankAccountDto result = customerMapper.map(customer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        customerManagementService.deleteBankAccountById(id);
        return ResponseEntity.ok().build();
    }

}
