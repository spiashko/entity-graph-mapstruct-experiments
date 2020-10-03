package com.siarhei.jpaefficiencyexperiments.web.rest;

import com.siarhei.jpaefficiencyexperiments.operation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OperationResource {

    private final OperationSummarySearchService summarySearchService;
    private final OperationViewCSearchService searchService;

    @GetMapping(value = "/operations")
    public ResponseEntity<List<OperationViewAModel>> getAllViewA() {
        List<OperationViewAModel> result = summarySearchService.findAll(OperationViewSelectors.viewA);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewb")
    public ResponseEntity<List<OperationViewBModel>> getAllViewB() {
        List<OperationViewBModel> result = summarySearchService.findAll(OperationViewSelectors.viewB);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewc")
    public ResponseEntity<List<OperationViewCModel>> getAllViewC() {
        List<OperationViewCModel> result = searchService.findAll(OperationViewSelectors.viewC);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/operations/{id}")
    public ResponseEntity<OperationViewAModel> getOneViewA(@PathVariable Long id) {
        OperationViewAModel result = summarySearchService.findOneOrThrow(id, OperationViewSelectors.viewA);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewb/{id}")
    public ResponseEntity<OperationViewBModel> getOneViewB(@PathVariable Long id) {
        OperationViewBModel result = summarySearchService.findOneOrThrow(id, OperationViewSelectors.viewB);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewc/{id}")
    public ResponseEntity<OperationViewCModel> getOneViewC(@PathVariable Long id) {
        OperationViewCModel result = searchService.findOneOrThrow(id, OperationViewSelectors.viewC);
        return ResponseEntity.ok(result);
    }

}
