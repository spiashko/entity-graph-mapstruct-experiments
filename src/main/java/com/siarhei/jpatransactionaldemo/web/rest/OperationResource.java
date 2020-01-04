package com.siarhei.jpatransactionaldemo.web.rest;

import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.CreateOperationDto;
import com.siarhei.jpatransactionaldemo.web.dto.moneytransfer.RetrieveOperationDto;
import com.siarhei.jpatransactionaldemo.web.mappers.OperationMapper;
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
public class OperationResource {

    private final OperationManagementService moneyTransferManagementService;
    private final OperationSearchService moneyTransferSearchService;
    private final OperationMapper moneyTransferMapper;

    @PostMapping("/money-transfers")
    public ResponseEntity<RetrieveOperationDto> createOperation(@RequestBody CreateOperationDto moneyTransferDto) throws URISyntaxException {
        Operation moneyTransfer = moneyTransferMapper.map(moneyTransferDto);
        Operation result = moneyTransferManagementService.createOperation(moneyTransfer);
        RetrieveOperationDto resultDto = moneyTransferMapper.map(result);
        return ResponseEntity.created(new URI("/money-transfers/" + result.getId()))
                .body(resultDto);
    }

    @GetMapping("/money-transfers")
    public ResponseEntity<List<RetrieveOperationDto>> getAllOperations(OperationFilter filter) {
        List<Operation> moneyTransfers = moneyTransferSearchService.findAll(filter);

        return ResponseEntity.ok(moneyTransfers.stream()
                .map(moneyTransferMapper::map)
                .collect(Collectors.toList()));
    }

    @GetMapping("/money-transfers/{id}")
    public ResponseEntity<RetrieveOperationDto> getOperation(@PathVariable Long id) {
        Operation moneyTransfer = moneyTransferSearchService.findOneOrThrow(id);
        return ResponseEntity.ok(moneyTransferMapper.map(moneyTransfer));
    }


}
