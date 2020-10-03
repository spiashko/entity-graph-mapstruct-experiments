package com.siarhei.jpaefficiencyexperiments.bankaccount;

public interface BalanceManagementService {

    void addToBalance(Long id, Long amount);

    void subtractFromBalance(Long id, Long amount);

}
