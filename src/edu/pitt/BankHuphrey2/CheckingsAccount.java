package edu.pitt.BankHuphrey2;

import java.util.Date;
/**
 *  Checking account class is a subclass created from the Accounts class. 
 * It is used to make withdrawals 
 * @author David Humphrey
 *
 */
public class CheckingsAccount extends Account {
	// minimum ammount to withdraw is $500
	final private double MIN_WITH = 5.00;
	// 35 dollar penalty for withdrawaling under MIN_WITH
	final private double PENALTY = 35.00;
	
	/**
	 * constructor that stores new account
	 * @param accountNum - stores account number
	 * @param initAmount - stored initial amount 
	 */
	
	public CheckingsAccount (long accountNum){
		super(accountNum);
	}
	
	public CheckingsAccount(long accountNum, double initAmount) {
		super(accountNum, initAmount);
	}

		/**
		 * @Override - overrides Accounts withdrawal method 
		 */
		public double withdraw(double withAmount, double overdraftPen){
			
				/*
				 * the if-else statement below makes full withdrawals to specified accounts 
				 * If the withdrawal is less than 500.00 a penalty is assessed and returns the balance 
				 */
			 if ( super.accountBal > withAmount && super.accountStatus.equals("active") ){
					super.accountBal -= withAmount;
					this.lastTran = new Date();
					
					
					if( withAmount < MIN_WITH){
						super.accountBal -= PENALTY;
						System.out.println(" Withdrawal amount cant be lower than $500.00. Penalty Amount: " + PENALTY);
						}
			}
			 	
			 	else{
			 		//penalty ammount if user has insufficient funds
					super.accountBal -= ( withAmount + overdraftPen);
					super.accountStatus = "non active";
					System.out.println(" INSUFFICIENT FUNDS! Account status is set to " + accountStatus + " account balance: $" + accountBal);
				}
			 
		
			return super.accountBal;
		}
	}


