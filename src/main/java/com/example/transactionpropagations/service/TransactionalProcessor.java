package com.example.transactionpropagations.service;
@FunctionalInterface
public interface TransactionalProcessor {
    void execute();
}
