package com.siarhei.jpatransactionaldemo.web.mappers;

import com.siarhei.jpatransactionaldemo.operation.Operation;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewADto;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewBDto;
import com.siarhei.jpatransactionaldemo.web.dto.operation.OperationViewCDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OperationWebMapper {

    @Mapping(target = "bankAccountId", source = "bankAccount.id")
    OperationViewADto mapToViewA(Operation entity);

    OperationViewBDto mapToViewB(Operation entity);

    OperationViewCDto mapToViewC(Operation entity);
}
