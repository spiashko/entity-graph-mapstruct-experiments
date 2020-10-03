package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.*;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BankAccountTests extends BaseApplicationTest {

    @Autowired
    private BankAccountManagementService managementService;
    @Autowired
    private BankAccountSearchService searchService;

    @Test
    void when_create_account_then_created() {
        //given
        SQLStatementCountValidator.reset();

        //when
        BankAccountViewAModel bankAccount = managementService.createBankAccount(BankAccountCreationModel.builder()
                .balance(100L)
                .build());

        //then
        Assertions.assertNotNull(bankAccount);
        Assertions.assertTrue(bankAccount.getId() > 0);
        Assertions.assertEquals(100L, bankAccount.getBalance());

        SQLStatementCountValidator.assertInsertCount(1);
        Assertions.assertEquals(2, QueryCountHolder.getGrandTotal().getTotal());
    }

    @Test
    void given_simple_account_when_get_account_view_a_then_one_record_retrieved() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        List<BankAccountViewAModel> all = searchService.findAll(BankAccountViewSelectors.viewA);

        //then
        Assertions.assertEquals(1, all.size());
        BankAccountViewAModel retrieveResponse = all.get(0);
        Assertions.assertEquals(createResponse.getBalance(), retrieveResponse.getBalance());
        Assertions.assertEquals(createResponse.getId(), retrieveResponse.getId());

        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());
    }

    @Test
    void given_simple_account_when_get_account_view_b_then_one_record_retrieved() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        List<BankAccountViewBModel> all = searchService.findAll(BankAccountViewSelectors.viewB);

        //then
        Assertions.assertEquals(1, all.size());
        BankAccountViewBModel retrieveResponse = all.get(0);
        Assertions.assertEquals(createResponse.getBalance(), retrieveResponse.getBalance());
        Assertions.assertEquals(createResponse.getId(), retrieveResponse.getId());

        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());
    }
}
