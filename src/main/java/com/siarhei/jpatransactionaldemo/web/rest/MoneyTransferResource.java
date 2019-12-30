package com.siarhei.jpatransactionaldemo.web.rest;

import com.siarhei.jpatransactionaldemo.dto.MoneyTransferDto;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferMapper;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class MoneyTransferResource {

    private final MoneyTransferService moneyTransferService;
    private final MoneyTransferMapper moneyTransferMapper;

    @PostMapping("/money-transfers")
    public ResponseEntity<MoneyTransferDto> createMoneyTransfer(@RequestBody MoneyTransfer moneyTransfer) throws URISyntaxException {
        MoneyTransfer result = moneyTransferService.createMoneyTransfer(moneyTransfer);
        return ResponseEntity.created(new URI("/money-transfers/" + result.getId()))
                .body(moneyTransferMapper.map(result));
    }

    @GetMapping("/money-transfers")
    public ResponseEntity<List<MoneyTransferDto>> getAllMoneyTransfers() {
        List<MoneyTransfer> moneyTransfers = moneyTransferService.getMoneyTransfers();

        return ResponseEntity.ok(moneyTransfers.stream()
                .map(moneyTransferMapper::map)
                .collect(Collectors.toList()));
    }

    @GetMapping("/money-transfers/{id}")
    public ResponseEntity<MoneyTransferDto> getMoneyTransfer(@PathVariable Long id) {
        MoneyTransfer moneyTransfer = moneyTransferService.getMoneyTransferById(id);
        return ResponseEntity.ok(moneyTransferMapper.map(moneyTransfer));
    }


}
