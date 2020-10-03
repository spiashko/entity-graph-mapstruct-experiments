package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountCreationModel;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountManagementService;
import com.siarhei.jpaefficiencyexperiments.bankaccount.BankAccountViewAModel;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankAccountTests extends ApplicationTests {

    @Autowired
    private BankAccountManagementService service;

    @Test
    void on_create_account_only_one_sql_executed() {
        SQLStatementCountValidator.reset();
        BankAccountViewAModel bankAccount = service.createBankAccount(BankAccountCreationModel.builder()
                .balance(100L)
                .build());
        SQLStatementCountValidator.assertInsertCount(1);
        Assertions.assertEquals(2, QueryCountHolder.getGrandTotal().getTotal());
    }
}
