package com.siarhei.jpatransactionaldemo.web.rest;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.siarhei.jpatransactionaldemo.operation.Operation;
import com.siarhei.jpatransactionaldemo.operation.OperationFilter;
import com.siarhei.jpatransactionaldemo.operation.OperationSearchService;
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

    private final OperationSearchService searchService;
    private final OperationWebMapper mapper;

    @GetMapping(value = "/operations")
    public ResponseEntity<List<OperationViewADto>> getAllViewA(OperationFilter filter) {
        List<Operation> entities = searchService.findAll(filter);
        return ResponseEntity.ok(entities.stream()
                .map(mapper::mapToViewA)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/operations-viewb")
    public ResponseEntity<List<OperationViewBDto>> getAllViewB(OperationFilter filter) {
        Iterable<Operation> entities = searchService.findAll(filter, EntityGraphs.named("Operation.bankAccount"));
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewB)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/operations-viewc")
    public ResponseEntity<List<OperationViewCDto>> getAllViewC(OperationFilter filter) {
        Iterable<Operation> entities = searchService.findAll(filter, EntityGraphs.named("Operation.all"));
        return ResponseEntity.ok(StreamSupport.stream(entities.spliterator(), false)
                .map(mapper::mapToViewC)
                .collect(Collectors.toList()));
    }

    @GetMapping("/operations/{id}")
    public ResponseEntity<OperationViewADto> getOneViewA(@PathVariable Long id) {
        Operation entity = searchService.findOneOrThrow(id);
        OperationViewADto result = mapper.mapToViewA(entity);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewb/{id}")
    public ResponseEntity<OperationViewBDto> getOneViewB(@PathVariable Long id) {
        Operation entity = searchService.findOneOrThrow(id, EntityGraphs.named("Operation.bankAccount"));
        OperationViewBDto result = mapper.mapToViewB(entity);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/operations-viewc/{id}")
    public ResponseEntity<OperationViewCDto> getOneViewC(@PathVariable Long id) {
        Operation entity = searchService.findOneOrThrow(id, EntityGraphs.named("Operation.all"));
        OperationViewCDto result = mapper.mapToViewC(entity);
        return ResponseEntity.ok(result);
    }

}
