package com.siarhei.jpatransactionaldemo.moneytransfer.management;

import com.siarhei.jpatransactionaldemo.moneytransfer.full.MoneyTransferFull;

public interface MoneyTransferManagementService {

    MoneyTransferFull createMoneyTransfer(MoneyTransferCreationModel createModel);

}
