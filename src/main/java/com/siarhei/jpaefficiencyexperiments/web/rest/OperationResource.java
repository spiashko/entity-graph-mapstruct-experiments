package com.siarhei.jpaefficiencyexperiments.web.rest;

import com.siarhei.jpaefficiencyexperiments.operation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class OperationResource {

    private final OperationSummarySearchService summarySearchService;
    private final OperationViewCSearchService searchService;

    @GetMapping(value = "/operations")
    public ResponseEntity<List<OperationViewAModel>> getAllViewA() {
        List<OperationViewAModel> result = summarySearchService.findAll(OperationViewAModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewb")
    public ResponseEntity<List<OperationViewBModel>> getAllViewB() {
        List<OperationViewBModel> result = summarySearchService.findAll(OperationViewBModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewc")
    public ResponseEntity<List<OperationViewCModel>> getAllViewC() {
        List<OperationViewCModel> result = searchService.findAll(OperationViewCModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/operations/{id}")
    public ResponseEntity<OperationViewAModel> getOneViewA(
            @PathVariable UUID id) {
        OperationViewAModel result = summarySearchService.findOneOrThrow(id, OperationViewAModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewb/{id}")
    public ResponseEntity<OperationViewBModel> getOneViewB(
            @PathVariable UUID id) {
        OperationViewBModel result = summarySearchService.findOneOrThrow(id, OperationViewBModel.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewc/{id}")
    public ResponseEntity<OperationViewCModel> getOneViewC(
            @PathVariable UUID id) {
        OperationViewCModel result = searchService.findOneOrThrow(id, OperationViewCModel.class);
        return ResponseEntity.ok(result);
    }

}
