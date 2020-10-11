package com.siarhei.jpaefficiencyexperiments;

import com.vladmihalcea.sql.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Assertions;

import java.util.function.Supplier;

public class AssertUtils {

    public static <T> T assertSelectCountExactlyOne(Supplier<T> runnable) {
        //given
        SQLStatementCountValidator.reset();

        //when
        T result = runnable.get();

        //then
        SQLStatementCountValidator.assertSelectCount(1);
        Assertions.assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());
        return result;
    }

}
