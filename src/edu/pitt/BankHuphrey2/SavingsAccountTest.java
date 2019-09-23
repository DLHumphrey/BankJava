package edu.pitt.BankHuphrey2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author David Humphrey
 *
 */
public class SavingsAccountTest {

	/**
	 *  Tests the deposit method of the savings account
	 * @Test
	 */
	public void testDeposit() {
		//creates a new account and deposits 1000
		SavingsAccount account = new SavingsAccount(11,1000);
		//deposits 500
		account.deposit(500);
		//becomes 1550 because of interest
		assertEquals("Balance after deposit should be 1550.00", 1550, (int)account.getAccountBal());
	}


}
