package com.siarhei.jpatransactionaldemo.web.rest;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import com.siarhei.jpatransactionaldemo.bankaccount.view.BankAccountCreateView;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccountFilter;
import com.siarhei.jpatransactionaldemo.bankaccount.service.BankAccountManagementService;
import com.siarhei.jpatransactionaldemo.bankaccount.service.BankAccountSearchService;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.BankAccountCreationDto;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.BankAccountViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.bankaccount.BankAccountViewBDto;
import com.siarhei.jpatransactionaldemo.web.mappers.BankAccountWebMapper;
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

    private final BankAccountManagementService managementService;
    private final BankAccountSearchService searchService;
    private final BankAccountWebMapper mapper;

    @PostMapping("/bank-accounts")
    public ResponseEntity<BankAccountViewADto> createBankAccount(@RequestBody BankAccountCreationDto customerDto) throws URISyntaxException {
        BankAccountCreateView customer = mapper.map(customerDto);
        BankAccount result = managementService.createBankAccount(customer);
        BankAccountViewADto resultDto = mapper.mapToViewA(result);
        return ResponseEntity.created(new URI("/bank-accounts/" + result.getId()))
                .body(resultDto);
    }

    @GetMapping("/bank-accounts")
    public ResponseEntity<List<BankAccountViewADto>> getAllBankAccounts(BankAccountFilter customerFilter) {
        List<BankAccount> bankAccounts = searchService.findAll(customerFilter);
        return ResponseEntity.ok(bankAccounts.stream()
                .map(mapper::mapToViewA)
                .collect(Collectors.toList()));
    }

    @GetMapping("/bank-accounts/{id}")
    public ResponseEntity<BankAccountViewADto> getOneViewA(@PathVariable Long id) {
        BankAccount customer = searchService.findOneOrThrow(id);
        BankAccountViewADto result = mapper.mapToViewA(customer);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/bank-accounts-viewb/{id}")
    public ResponseEntity<BankAccountViewBDto> getOneViewB(@PathVariable Long id) {
        BankAccount customer = searchService.findOneOrThrow(id, EntityGraphs.named("BankAccount.operations"));
        BankAccountViewBDto result = mapper.mapToViewB(customer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/bank-accounts/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        managementService.deleteBankAccountById(id);
        return ResponseEntity.ok().build();
    }

}
