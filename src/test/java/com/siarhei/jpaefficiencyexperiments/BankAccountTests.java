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
    void whenCreateAccount_thenCreated() {
        //given
        SQLStatementCountValidator.reset();

        //when
        BankAccountViewAModel bankAccount = managementService.createBankAccount(BankAccountCreationModel.builder()
                .balance(100L)
                .build());

        //then
        SQLStatementCountValidator.assertInsertCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertNotNull(bankAccount);
        Assertions.assertNotNull(bankAccount.getId());
        Assertions.assertEquals(100L, bankAccount.getBalance());
    }

    @Test
    void givenOneAccount_whenFindAllAccountViewA_thenOneRecordRetrieved() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        List<BankAccountViewAModel> all = searchService.findAll(BankAccountViewAModel.class);

        //then
        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertEquals(1, all.size());
        BankAccountViewAModel retrieveResponse = all.get(0);
        Assertions.assertEquals(createResponse.getBalance(), retrieveResponse.getBalance());
        Assertions.assertEquals(createResponse.getId(), retrieveResponse.getId());
    }

    @Test
    void givenOneAccount_whenFindOneAccountViewA_thenOneRecordRetrieved() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        BankAccountViewAModel retrieveResponse = searchService.findOneOrThrow(createResponse.getId(),
                BankAccountViewAModel.class);

        //then
        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertEquals(createResponse.getBalance(), retrieveResponse.getBalance());
        Assertions.assertEquals(createResponse.getId(), retrieveResponse.getId());
    }

    @Test
    void givenOneAccount_whenFindAllAccountViewB_thenOneRecordRetrieved() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        List<BankAccountViewBModel> all = searchService.findAll(BankAccountViewBModel.class);

        //then
        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertEquals(1, all.size());
        BankAccountViewBModel retrieveResponse = all.get(0);
        Assertions.assertEquals(createResponse.getBalance(), retrieveResponse.getBalance());
        Assertions.assertEquals(createResponse.getId(), retrieveResponse.getId());
    }

    @Test
    void givenOneAccount_whenFindOneAccountViewB_thenOneRecordRetrieved() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when
        BankAccountViewBModel retrieveResponse = searchService.findOneOrThrow(createResponse.getId(),
                BankAccountViewBModel.class);

        //then
        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());

        Assertions.assertEquals(createResponse.getBalance(), retrieveResponse.getBalance());
        Assertions.assertEquals(createResponse.getId(), retrieveResponse.getId());
    }
}
