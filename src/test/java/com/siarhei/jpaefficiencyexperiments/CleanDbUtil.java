package com.siarhei.jpaefficiencyexperiments;

import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

public class CleanDbUtil {

    public static void cleanStore(final TransactionTemplate transactionTemplate, final EntityManager entityManager) {
        transactionTemplate.execute(transactionStatus -> {
            entityManager.createQuery("delete from CashAction where id > 0").executeUpdate();
            entityManager.createQuery("delete from MoneyTransfer where id > 0").executeUpdate();
            entityManager.createQuery("delete from Operation where id > 0").executeUpdate();
            entityManager.createQuery("delete from BankAccount where id > 0").executeUpdate();
            entityManager.flush();
            return null;
        });
    }
}
