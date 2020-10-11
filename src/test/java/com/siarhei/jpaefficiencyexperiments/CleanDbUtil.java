package com.siarhei.jpaefficiencyexperiments;

import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

public class CleanDbUtil {

    public static void cleanStore(final TransactionTemplate transactionTemplate, final EntityManager entityManager) {
        transactionTemplate.execute(transactionStatus -> {
            entityManager.createQuery("delete from CashAction").executeUpdate();
            entityManager.createQuery("delete from MoneyTransfer").executeUpdate();
            entityManager.createQuery("delete from Operation").executeUpdate();
            entityManager.createQuery("delete from BankAccount").executeUpdate();
            entityManager.flush();
            return null;
        });
    }
}
