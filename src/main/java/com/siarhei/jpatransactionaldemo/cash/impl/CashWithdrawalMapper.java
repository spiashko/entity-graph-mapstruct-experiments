package com.siarhei.jpatransactionaldemo.cash.impl;

import com.siarhei.jpatransactionaldemo.cash.CashWithdrawalModel;
import com.siarhei.jpatransactionaldemo.cash.CreateCashWithdrawalModel;
import com.siarhei.jpatransactionaldemo.crudbase.mapper.BaseEntityModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CashWithdrawalMapper extends BaseEntityModelMapper<CashWithdrawal, CashWithdrawalModel, CreateCashWithdrawalModel> {

    CashWithdrawal map(CreateCashWithdrawalModel model);

    CashWithdrawalModel map(CashWithdrawal entity);

}
