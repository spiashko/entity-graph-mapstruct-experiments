package com.siarhei.jpatransactionaldemo.operation;

public enum OperationSource {
    //in
    RECEIVE_MONEY_TRANSFER,
    CASH_REFILL,

    //out
    SEND_MONEY_TRANSFER,
    CASH_WITHDRAWAL,
}