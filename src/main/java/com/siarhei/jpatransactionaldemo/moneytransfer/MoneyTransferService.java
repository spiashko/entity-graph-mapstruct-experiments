package com.siarhei.jpatransactionaldemo.moneytransfer;

import java.util.List;

public interface MoneyTransferService {

    MoneyTransfer createMoneyTransfer(MoneyTransfer moneyTransfer);

    MoneyTransfer getMoneyTransferById(Long id);

    List<MoneyTransfer> getMoneyTransfers();

}
