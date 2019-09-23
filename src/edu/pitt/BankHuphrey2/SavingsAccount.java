package edu.pitt.BankHuphrey2;

import java.util.Date;

/**
 * Savings account class is a subclass created from the Accounts class. 
 * It is used to deposit money into savings account
 * @author David Humphrey
 *
 */
public class SavingsAccount extends Account{
	
	//2% interest
	final double FINAL_INTEREST = .02;
	
	/**
	 *  subclass from Account class 
	 * @param accountNum - stores account number for account
	 */
	public SavingsAccount(long accountNum){
		super(accountNum);
	}
	/**
	 * 
	 * @param accountNum - stores account number for savings account
	 * @param initAmount - stores initial account ammount
	 */
	public SavingsAccount(long accountNum, double initAmount) {
		super(accountNum, initAmount);
		// TODO Auto-generated constructor stub
		
	}
	

	/**
	 * @Override - overides Account classes deposit method 
	 * @param depAmount - stores deposit ammount
	 *  transacts a deposit and returns the accoutn balance
	 */
	
	public double deposit(double depAmount){
	
		// adds deposit amount to account balance
					super.accountBal += depAmount;
					//ADDS INTEREST of 
					super.accountBal += (super.accountBal * FINAL_INTEREST);
					
					// lets program know date of this transaction
					super.lastTran = new Date();
					
					
					return super.accountBal;
					
		
		
	}
	
}
