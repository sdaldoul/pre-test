package com.priceminister.account;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.priceminister.account.implementation.CustomerAccount;

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
     * Tests that an illegal withdrawal throws the expected exception. Use the logic contained in
     * CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
       // fail("not yet implemented");
    }
    
    // Also implement missing unit tests for the above functionalities.
    
}
