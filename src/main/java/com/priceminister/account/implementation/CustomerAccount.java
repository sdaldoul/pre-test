package com.priceminister.account.implementation;

import com.priceminister.account.Account;
import com.priceminister.account.AccountRule;
import com.priceminister.account.IllegalBalanceException;

public class CustomerAccount implements Account {
    
    private Double accountBalance = 0.0;
    
    public void add(Double addedAmount) {
        AccountRule.checkAmountPositive(addedAmount);
        accountBalance = accountBalance + addedAmount;
    }
    
    public Double getBalance() {
        if (accountBalance == null) {
            accountBalance = 0.0;
        }
        return accountBalance;
    }
    
    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
        throws IllegalBalanceException {
        
        if (rule == null) {
            throw new IllegalArgumentException("You must provide a rule");
        }
        
        AccountRule.checkAmountPositive(withdrawnAmount);
        Double localBalance = accountBalance - withdrawnAmount;
        if (!rule.withdrawPermitted(localBalance)) {
            throw new IllegalBalanceException(localBalance);
        }
        accountBalance = localBalance;
        return accountBalance;
    }
}
