package com.siarhei.jpatransactionaldemo.bankaccount.view;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.siarhei.jpatransactionaldemo.bankaccount.BankAccount;
import lombok.Getter;
import lombok.Setter;

@CreatableEntityView
@EntityView(BankAccount.class)
@Getter
@Setter
public class BankAccountCreateView {

    private Long balance;

}
