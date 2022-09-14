package com.bdsystems.useraccounts.accountbalance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private BigDecimal accountBalance;
}

