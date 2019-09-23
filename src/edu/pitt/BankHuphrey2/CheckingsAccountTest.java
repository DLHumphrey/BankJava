package edu.pitt.BankHuphrey2;

import static org.junit.Assert.*;

import org.junit.Test;

 
/**
 * Used to test to see if withdrawal works in the checkings account
 * @author David Humphrey
 *
 */
public class CheckingsAccountTest {

	/**
	 *  Tests the withdrawal method of the savings account
	 * @Test
	 */
	public void testWithdraw() {
		//creates new account and deposits 1000 
		CheckingsAccount account = new CheckingsAccount(11, 1000);
		//withdraws 700 from same account
		account.withdraw(700, 35.00);
		// balance should be 500
		assertEquals("Balance after withdrawal should be 500", 500, (int)account.getAccountBal());
		
	}

}
