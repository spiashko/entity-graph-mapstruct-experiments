package com.siarhei.jpatransactionaldemo.web.rest;

import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class MoneyTransferResource {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferResource(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping("/money-transfers")
    public ResponseEntity<MoneyTransfer> createMoneyTransfer(@RequestBody MoneyTransfer moneyTransfer) throws URISyntaxException {
        MoneyTransfer result = moneyTransferService.createMoneyTransfer(moneyTransfer);
        return ResponseEntity.created(new URI("/api/money-transfers/" + result.getId()))
                .body(result);
    }

    @GetMapping("/money-transfers")
    public ResponseEntity<List<MoneyTransfer>> getAllMoneyTransfers() {
        List<MoneyTransfer> moneyTransfers = moneyTransferService.getMoneyTransfers();
        return ResponseEntity.ok(moneyTransfers);
    }

    @GetMapping("/money-transfers/{id}")
    public ResponseEntity<MoneyTransfer> getMoneyTransfer(@PathVariable Long id) {
        MoneyTransfer moneyTransfer = moneyTransferService.getMoneyTransferById(id);
        return ResponseEntity.ok(moneyTransfer);
    }


}
