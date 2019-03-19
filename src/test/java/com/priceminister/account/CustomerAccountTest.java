package com.priceminister.account;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.priceminister.account.implementation.CustomerAccount;
import com.priceminister.account.implementation.CustomerAccountRule;

/**
 * Please create the business code, starting from the unit tests below. Implement the first test,
 * the develop the code that makes it pass. Then focus on the second test, and so on. We want to see
 * how you "think code", and how you organize and structure a simple application. When you are done,
 * please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 */
public class CustomerAccountTest {
    
    Account     customerAccount;
    AccountRule rule;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        Double expectedAmount = 0.0;
        assertEquals(expectedAmount, customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        Double addedAmount1 = 5.30;
        Double addedAmount2 = 4.71;
        Double expectedAmount = 10.01;
        customerAccount.add(addedAmount1);
        customerAccount.add(addedAmount2);
        assertEquals(expectedAmount, customerAccount.getBalance());
    }
    
    /**
     * Test add negtive amount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddNegtiveAmount() {
        Double addedAmount2 = -4.71;
        customerAccount.add(addedAmount2);
    }
    
    /**
     * Test add null amount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAmount() {
        
        customerAccount.add(null);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception. Use the logic contained in
     * CustomerAccountRule;
     * 
     * @throws IllegalBalanceException
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        Double addedAmount1 = 5.30;
        customerAccount.add(addedAmount1);
        
        Double withdrawnAmount = 40.71;
        customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
        
    }
    
    /**
     * Test withdraw negative amount.
     *
     * @throws IllegalBalanceException the illegal balance exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() throws IllegalBalanceException {
        Double addedAmount1 = 5.30;
        customerAccount.add(addedAmount1);
        
        Double withdrawnAmount = -40.71;
        customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
        
    }
    
    /**
     * Test withdraw null amount.
     *
     * @throws IllegalBalanceException the illegal balance exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNullAmount() throws IllegalBalanceException {
        
        customerAccount.withdrawAndReportBalance(null, rule);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNullRule() throws IllegalBalanceException {
        
        Double addedAmount1 = 5.30;
        customerAccount.add(addedAmount1);
        Double withdrawnAmount = 4.71;
        customerAccount.withdrawAndReportBalance(withdrawnAmount, null);
        
    }
    
    /**
     * Test withdraw ok.
     *
     * @throws IllegalBalanceException the illegal balance exception
     */
    @Test
    public void testWithdrawOk() throws IllegalBalanceException {
        Double addedAmount1 = 5.30;
        Double expectedAmount = 4.10;
        customerAccount.add(addedAmount1);
        
        Double withdrawnAmount = 1.20;
        customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
        assertEquals(expectedAmount, customerAccount.getBalance());
        
    }
    
}
