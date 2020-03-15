package com.siarhei.jpatransactionaldemo.web.rest;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationSummary;
import com.siarhei.jpatransactionaldemo.operation.OperationSummarySearchService;
import com.siarhei.jpatransactionaldemo.operation.OperationViewC;
import com.siarhei.jpatransactionaldemo.operation.OperationViewCSearchService;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewBDto;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewCDto;
import com.siarhei.jpatransactionaldemo.web.mappers.OperationWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Controller
public class OperationResource {

    private final OperationSummarySearchService summarySearchService;
    private final OperationViewCSearchService searchService;
    private final OperationWebMapper mapper;

    @GetMapping(value = "/operations")
    public ResponseEntity<List<OperationViewADto>> getAllViewA(OperationFilter filter) {
        Iterable<OperationSummary> entities = summarySearchService.findAll(filter);
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewA)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/operations-viewb")
    public ResponseEntity<List<OperationViewBDto>> getAllViewB(OperationFilter filter) {
        Iterable<OperationSummary> entities = summarySearchService.findAll(filter, EntityGraphs.named("Operation.viewb"));
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewB)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/operations-viewc")
    public ResponseEntity<List<OperationViewCDto>> getAllViewC(OperationFilter filter) {
        Iterable<OperationViewC> entities = searchService.findAll(filter, EntityGraphs.named("Operation.viewc"));
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewC)
                .collect(Collectors.toList()));
    }

    @GetMapping("/operations/{id}")
    public ResponseEntity<OperationViewADto> getOneViewA(@PathVariable Long id) {
        OperationSummary entity = summarySearchService.findOneOrThrow(id);
        OperationViewADto result = mapper.mapToViewA(entity);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewb/{id}")
    public ResponseEntity<OperationViewBDto> getOneViewB(@PathVariable Long id) {
        OperationSummary entity = summarySearchService.findOneOrThrow(id, EntityGraphs.named("Operation.viewb"));
        OperationViewBDto result = mapper.mapToViewB(entity);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewc/{id}")
    public ResponseEntity<OperationViewCDto> getOneViewC(@PathVariable Long id) {
        OperationViewC entity = searchService.findOneOrThrow(id, EntityGraphs.named("Operation.viewc"));
        OperationViewCDto result = mapper.mapToViewC(entity);
        return ResponseEntity.ok(result);
    }

}
