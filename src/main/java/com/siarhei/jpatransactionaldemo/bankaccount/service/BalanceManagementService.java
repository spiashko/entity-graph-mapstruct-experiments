package com.siarhei.jpatransactionaldemo.bankaccount.service;

public interface BalanceManagementService {

    void addToBalance(Long id, Long amount);

    void subtractFromBalance(Long id, Long amount);

}
