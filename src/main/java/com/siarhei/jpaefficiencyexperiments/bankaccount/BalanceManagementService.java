package com.siarhei.jpaefficiencyexperiments.bankaccount;

import java.util.UUID;

public interface BalanceManagementService {

    void addToBalance(UUID id, Long amount);

    void subtractFromBalance(UUID id, Long amount);

}
