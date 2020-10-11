package com.siarhei.jpaefficiencyexperiments;

import com.siarhei.jpaefficiencyexperiments.bankaccount.*;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    void givenOneAccount_whenFindAccountViewX_thenOnlyOneSqlExecuted() {
        //given
        BankAccountViewAModel createResponse =
                managementService.createBankAccount(BankAccountCreationModel.builder()
                        .balance(100L)
                        .build());
        SQLStatementCountValidator.reset();

        //when-then
        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findAll(BankAccountViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findAll(BankAccountViewBModel.class));

        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findOneOrThrow(createResponse.getId(), BankAccountViewAModel.class));
        AssertUtils.assertSelectCountExactlyOne(() -> searchService.findOneOrThrow(createResponse.getId(), BankAccountViewBModel.class));
    }
}
