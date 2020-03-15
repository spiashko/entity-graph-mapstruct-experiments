package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.operation.OperationSummary;
import com.siarhei.jpatransactionaldemo.operation.OperationViewC;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewBDto;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewCDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OperationWebMapper {

    @Mapping(target = "bankAccountId", source = "bankAccount.id")
    OperationViewADto mapToViewA(OperationSummary entity);

    OperationViewBDto mapToViewB(OperationSummary entity);

    OperationViewCDto mapToViewC(OperationViewC entity);
}
