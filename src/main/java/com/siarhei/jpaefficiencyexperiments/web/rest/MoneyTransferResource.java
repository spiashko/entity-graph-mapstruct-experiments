package com.siarhei.jpaefficiencyexperiments.web.rest;

import com.siarhei.jpaefficiencyexperiments.moneytransfer.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class MoneyTransferResource {

    private final MoneyTransferManagementService managementService;
    private final MoneyTransferSearchService searchService;

    @SneakyThrows
    @PostMapping("/money-transfers")
    public ResponseEntity<MoneyTransferViewBModel> createMoneyTransfer(
            @RequestBody MoneyTransferCreationModel creationModel) {
        MoneyTransferViewBModel result = managementService.createMoneyTransfer(creationModel);
        return ResponseEntity.created(new URI("/money-transfers/" + result.getId()))
                .body(result);
    }

    @GetMapping(value = "/money-transfers")
    public ResponseEntity<List<MoneyTransferViewAModel>> getAllViewA() {
        List<MoneyTransferViewAModel> result = searchService.findAll(MoneyTransferViewAModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/money-transfers-viewb")
    public ResponseEntity<List<MoneyTransferViewBModel>> getAllViewB() {
        List<MoneyTransferViewBModel> result = searchService.findAll(MoneyTransferViewBModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/money-transfers/{id}")
    public ResponseEntity<MoneyTransferViewAModel> getOneViewA(
            @PathVariable UUID id) {
        MoneyTransferViewAModel result = searchService.findOneOrThrow(id, MoneyTransferViewAModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/money-transfers-viewb/{id}")
    public ResponseEntity<MoneyTransferViewBModel> getOneViewB(
            @PathVariable UUID id) {
        MoneyTransferViewBModel result = searchService.findOneOrThrow(id, MoneyTransferViewBModel.class);
        return ResponseEntity.ok(result);
    }

}
