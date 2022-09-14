package com.bdsystems.useraccounts.accountbalance.service;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class CurrencyExchangeService {

    private static final BigDecimal usdValue = new BigDecimal(new Random().nextFloat() * 5);

    protected BigDecimal recalculateToUsd(BigDecimal plnAmount) {
        return plnAmount.divide(usdValue).setScale(2);
    }
}
