package com.siarhei.jpatransactionaldemo.moneytransfer;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface MoneyTransferService {

    MoneyTransfer createMoneyTransfer(MoneyTransfer moneyTransfer);

    MoneyTransfer getMoneyTransferById(Long id);

    List<MoneyTransfer> getMoneyTransfers();

}
