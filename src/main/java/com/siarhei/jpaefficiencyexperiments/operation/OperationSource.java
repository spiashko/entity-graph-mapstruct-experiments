package com.siarhei.jpaefficiencyexperiments.operation;

public enum OperationSource {
    //in
    RECEIVE_MONEY_TRANSFER,
    CASH_REFILL,

    //out
    SEND_MONEY_TRANSFER,
    CASH_WITHDRAWAL,
}