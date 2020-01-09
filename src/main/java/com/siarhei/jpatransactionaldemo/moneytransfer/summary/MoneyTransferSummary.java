package com.siarhei.jpatransactionaldemo.moneytransfer.summary;

import com.siarhei.jpatransactionaldemo.moneytransfer.base.BaseMoneyTransfer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "money_transfer")
public class MoneyTransferSummary extends BaseMoneyTransfer {

}
