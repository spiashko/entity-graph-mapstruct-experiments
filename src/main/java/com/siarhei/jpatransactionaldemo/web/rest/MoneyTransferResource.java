package com.siarhei.jpatransactionaldemo.web.rest;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransfer;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpatransactionaldemo.moneytransfer.MoneyTransferSearchService;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferCreationDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.MoneyTransferViewBDto;
import com.siarhei.jpatransactionaldemo.web.mappers.MoneyTransferWebMapper;
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
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Controller
public class MoneyTransferResource {

    private final MoneyTransferManagementService managementService;
    private final MoneyTransferSearchService searchService;
    private final MoneyTransferWebMapper mapper;

    @PostMapping("/money-transfers")
    public ResponseEntity<MoneyTransferViewBDto> createMoneyTransfer(@RequestBody MoneyTransferCreationDto moneyTransferDto) throws URISyntaxException {
        MoneyTransferCreationModel moneyTransfer = mapper.map(moneyTransferDto);
        MoneyTransfer result = managementService.createMoneyTransfer(moneyTransfer);
        MoneyTransferViewBDto resultDto = mapper.mapToViewB(result);
        return ResponseEntity.created(new URI("/money-transfers/" + result.getId()))
                .body(resultDto);
    }

    @GetMapping(value = "/money-transfers")
    public ResponseEntity<List<MoneyTransferViewADto>> getAllViewA(MoneyTransferFilter filter) {
        List<MoneyTransfer> entities = searchService.findAll(filter);
        return ResponseEntity.ok(entities.stream()
                .map(mapper::mapToViewA)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/money-transfers-viewb")
    public ResponseEntity<List<MoneyTransferViewBDto>> getAllViewB(MoneyTransferFilter filter) {
        Iterable<MoneyTransfer> entities = searchService.findAll(filter, EntityGraphs.named("MoneyTransfer.all"));
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewB)
                .collect(Collectors.toList()));
    }

    @GetMapping("/money-transfers/{id}")
    public ResponseEntity<MoneyTransferViewADto> getOneViewA(@PathVariable Long id) {
        MoneyTransfer entity = searchService.findOneOrThrow(id);
        return ResponseEntity.ok(mapper.mapToViewA(entity));
    }

    @GetMapping("/money-transfers-viewb/{id}")
    public ResponseEntity<MoneyTransferViewBDto> getOneViewB(@PathVariable Long id) {
        MoneyTransfer entity = searchService.findOneOrThrow(id, EntityGraphs.named("MoneyTransfer.all"));
        return ResponseEntity.ok(mapper.mapToViewB(entity));
    }


}
