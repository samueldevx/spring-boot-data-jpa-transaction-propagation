package com.example.transactionpropagations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.transactionpropagations")
public class TransactionPropagationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionPropagationsApplication.class, args);
    }

}
