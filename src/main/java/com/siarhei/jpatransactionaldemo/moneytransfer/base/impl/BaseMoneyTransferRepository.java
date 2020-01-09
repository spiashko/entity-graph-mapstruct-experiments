package com.siarhei.jpatransactionaldemo.moneytransfer.base.impl;

import com.siarhei.jpatransactionaldemo.crudbase.repository.BaseJournalRepository;
import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransfer;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseMoneyTransferRepository<E extends BaseMoneyTransfer> extends BaseJournalRepository<E> {

}
