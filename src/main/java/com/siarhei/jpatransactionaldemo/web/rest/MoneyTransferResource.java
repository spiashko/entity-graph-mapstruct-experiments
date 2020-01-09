package com.siarhei.jpatransactionaldemo.web.rest;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFullFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFullSearchService;
import com.siarhei.jpatransactionaldemo.moneytransfer.management.MoneyTransferCreationModel;
import com.siarhei.jpatransactionaldemo.moneytransfer.management.MoneyTransferManagementService;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummary;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummaryFilter;
import com.siarhei.jpatransactionaldemo.moneytransfer.summary.MoneyTransferSummarySearchService;
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
    private final MoneyTransferFullSearchService fullSearchService;
    private final MoneyTransferSummarySearchService summarySearchService;
    private final MoneyTransferWebMapper mapper;

    @PostMapping("/money-transfers")
    public ResponseEntity<MoneyTransferViewBDto> createMoneyTransfer(@RequestBody MoneyTransferCreationDto moneyTransferDto) throws URISyntaxException {
        MoneyTransferCreationModel moneyTransfer = mapper.map(moneyTransferDto);
        MoneyTransferFull result = managementService.createMoneyTransfer(moneyTransfer);
        MoneyTransferViewBDto resultDto = mapper.mapToViewB(result);
        return ResponseEntity.created(new URI("/money-transfers/" + result.getId()))
                .body(resultDto);
    }

    @GetMapping(value = "/money-transfers")
    public ResponseEntity<List<MoneyTransferViewADto>> getAllViewA(MoneyTransferSummaryFilter filter) {
        List<MoneyTransferSummary> entities = summarySearchService.findAll(filter);
        return ResponseEntity.ok(entities.stream()
                .map(mapper::mapToViewA)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/money-transfers-viewb")
    public ResponseEntity<List<MoneyTransferViewBDto>> getAllViewB(MoneyTransferFullFilter filter) {
        Iterable<MoneyTransferFull> entities = fullSearchService.findAll(filter, EntityGraphs.named("MoneyTransferFull.all"));
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewB)
                .collect(Collectors.toList()));
    }

    @GetMapping("/money-transfers/{id}")
    public ResponseEntity<MoneyTransferViewADto> getOneViewA(@PathVariable Long id) {
        MoneyTransferSummary entity = summarySearchService.findOneOrThrow(id);
        return ResponseEntity.ok(mapper.mapToViewA(entity));
    }

    @GetMapping("/money-transfers-viewb/{id}")
    public ResponseEntity<MoneyTransferViewBDto> getOneViewB(@PathVariable Long id) {
        MoneyTransferFull entity = fullSearchService.findOneOrThrow(id, EntityGraphs.named("MoneyTransferFull.all"));
        return ResponseEntity.ok(mapper.mapToViewB(entity));
    }


}
