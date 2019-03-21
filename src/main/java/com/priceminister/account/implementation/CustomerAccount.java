package com.priceminister.account.implementation;

import com.priceminister.account.Account;
import com.priceminister.account.AccountRule;
import com.priceminister.account.IllegalBalanceException;
import com.priceminister.account.utils.Args;

public class CustomerAccount implements Account {
    
    private Double accountBalance = 0.0;
    
    public void add(Double addedAmount) {
        Args.positive(addedAmount, "You must provide a positive amount");
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
        
        Args.notNull(rule, "You must provide a rule");
        Args.positive(withdrawnAmount, "You must provide a positive amount");
        
        Double localBalance = accountBalance - withdrawnAmount;
        if (!rule.withdrawPermitted(localBalance)) {
            throw new IllegalBalanceException(localBalance);
        }
        accountBalance = localBalance;
        return accountBalance;
    }
}
