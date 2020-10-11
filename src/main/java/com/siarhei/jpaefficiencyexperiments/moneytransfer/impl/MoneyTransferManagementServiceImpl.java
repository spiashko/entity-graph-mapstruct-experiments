package com.siarhei.jpaefficiencyexperiments.moneytransfer.impl;

import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransfer;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferCreationModel;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferManagementService;
import com.siarhei.jpaefficiencyexperiments.moneytransfer.MoneyTransferViewBModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
public class MoneyTransferManagementServiceImpl implements MoneyTransferManagementService {

    private final MoneyTransferRepository repository;
    private final MoneyTransferSearchMapper searchMapper;
    private final MoneyTransferCreationMapper creationMapper;
    private final EntityManager entityManager;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MoneyTransferViewBModel createMoneyTransfer(MoneyTransferCreationModel createModel) {
        MoneyTransfer moneyTransfer = creationMapper.map(createModel, entityManager);
        repository.save(moneyTransfer);
        return searchMapper.mapToViewB(moneyTransfer);
    }

}
