package com.bdsystems.useraccounts.accountbalance.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class UserAccountBalance {

    private int id;
    private BigDecimal accountBalance;
}
