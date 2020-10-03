package com.siarhei.jpaefficiencyexperiments.web.rest;

import com.siarhei.jpaefficiencyexperiments.bankaccount.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BankAccountResource {

    private final BankAccountManagementService managementService;
    private final BankAccountSearchService searchService;

    @PostMapping("/bank-accounts")
    public ResponseEntity<BankAccountViewAModel> createBankAccount(
            @RequestBody BankAccountCreationModel creationModel) throws URISyntaxException {
        BankAccountViewAModel result = managementService.createBankAccount(creationModel);
        return ResponseEntity.created(new URI("/bank-accounts/" + result.getId()))
                .body(result);
    }

    @GetMapping("/bank-accounts")
    public ResponseEntity<List<BankAccountViewAModel>> getAllViewA() {
        List<BankAccountViewAModel> result = searchService.findAll(BankAccountViewSelectors.viewA);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/bank-accounts/{id}")
    public ResponseEntity<BankAccountViewAModel> getOneViewA(@PathVariable Long id) {
        BankAccountViewAModel result = searchService.findOneOrThrow(id, BankAccountViewSelectors.viewA);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/bank-accounts-viewb/{id}")
    public ResponseEntity<BankAccountViewBModel> getOneViewB(@PathVariable Long id) {
        BankAccountViewBModel result = searchService.findOneOrThrow(id, BankAccountViewSelectors.viewB);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/bank-accounts-viewb")
    public ResponseEntity<List<BankAccountViewBModel>> getAllViewB() {
        List<BankAccountViewBModel> result = searchService.findAll(BankAccountViewSelectors.viewB);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/bank-accounts/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        managementService.deleteBankAccountById(id);
        return ResponseEntity.ok().build();
    }

}
