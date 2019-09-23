package edu.pitt.BankHuphrey2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Create and modifies accounts, withdrawals and deposits
 * @author David Humphrey
 *
 */
public class Account {
		// used to store the list of account owners
		private ArrayList<User> accountOwner = new ArrayList<User>();
		// stores address 
		Address adress1 = new Address("2490 Dogwood Dr", "", "Wexford", "PA", 15090);
		//stores pin number of account
		private int pinNumber;
		// used for storing the account number 
		private long accountNum;
		// used for storing the account type
		private String accountType;
		// account status is automatically closed until new account created 
		protected String accountStatus = "active";
		// sets initial balance to 0.00
		protected double accountBal= 0.0;
		// stores the date the account was created 
		Date dateCreated;
		//stores who made the account
		private int openedBy;
		// stores date of last transactions
		Date lastTran;
		
		/**
		 * sets account number properly
		 * @param accountNum - stores account number
		 */
		public Account (long accountNum){
			this.accountNum = accountNum;
		}
		
		/**
		 * used for creating accounts.
		 * @param accountNum - Sets account number 
		 * @param initAmount sets initial amount
		 */
		public Account (long accountNum, double initAmount){
			this.accountNum = accountNum;
			this.deposit(initAmount);
		}
		
		/**
		 *  Used for creating a new user.
		 *  
		 * @param lName - sets last name 
		 * @param mInit sets middle iniitial
		 * @param fName sets first name
		 * @param doB sets date of birth
		 * @param address sets address
		 * @param userrType sets user type
		 * @param ssn sets social security
		 */
		public void newUser(String lName, String mInit, String fName, String doB, Address address, String userrType, int ssn){
			User user1 = new User(lName, mInit, fName, doB , address, userrType, ssn);
			accountOwner.add(user1);
			
		}
		
		/**
		 *  used to return a list of all users created 
		 * @return accountOwner 
		 */
		public ArrayList<User> UserRetList(){
			return accountOwner;
		}
		
		/**
		 * 
		 * Used to deposit money into an account
		 * @param depAmount - stores deposit amount
		 * @return accountBal
		 */
		public double deposit(double depAmount){
			
			// adds deposit amount to account balance
			accountBal += depAmount;
			// lets program know date of this transaction
			this.lastTran = new Date();
			//System.out.println("last transaction:" + depAmount + ", on" + lastTran);
			
			return accountBal;
			
		}
		
		/**
		 * used to withdraw money from a specific account
		 * @param withAmount - stores withdrawal amount
		 * @param overdraftPen - stores overdraft penalty
		 * @return
		 */
		public double withdraw(double withAmount, double overdraftPen){
			
			/*
			 * CODE BELOW:
			 * Withdraws the amount requested if there is sufficient funds,
			 * warns and penalizes user if insufficient
			 */
			if( accountBal >= withAmount && accountStatus.equals("active") ){
				accountBal -= withAmount;
				this.lastTran = new Date();
				//System.out.println("last transaction:" + lastTran);
				//System.out.println("Withdrawal successful! Account Balance: $" + accountBal);
			}else{
				accountBal -= ( withAmount + overdraftPen);
				accountStatus = "non active";
				//System.out.println("Withdrawal unsuccessful, INSUFFICIENT FUNDS! Account status is set to " + accountStatus + " account balance: $" + accountBal);
			}
			
			return accountBal;
		}
		
		/**
		 * Used to get account status 
		 * @return accountStatus 
		 */
		public String getAccountStatus() {
			return accountStatus;
		}
		
		/**
		 * sets accounts status 
		 * @param accountStatus
		 */
		public void setAccountStatus(String accountStatus) {
			this.accountStatus = accountStatus;
		}
		
		/**
		 * fetches and returns account number
		 * @return accountNum
		 */
		public long getAccountNum() {
			return accountNum;
		}
		
		/**
		 * sets accountNumber 
		 * @param accountNum
		 */
		public void setAccountNum(long accountNum) {
			this.accountNum = accountNum;
		}
		
		/**
		 * fetches and returns accountType
		 * @return accountType
		 */
		
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		
		public String getAccountType() {
			return accountType;
		}
		
		
		/**
		 * fetches and returns account balance
		 * @return accountBal;
		 */
		public double getAccountBal() {
			return accountBal;
		}
		/**
		 * fetches and returns the date an account is created 
		 * @return getDateCreated 
		 */
		public Date getDateCreated() {
			

			return dateCreated;
		}
		
		/**
		 * fetches and returns who the account was opened by
		 * @return openedBy
		 */
		public int getOpenedBy() {
			return openedBy;
		}
		
		/**
		 * fetches and returns the last transaction
		 * @return lastTran
		 */
		public Date getLastTran() {
			return lastTran;}
		
		/**
		 * fethes and returns pin number
		 * @return pinNumber
		 */
		public int getPinNumber() {
			return pinNumber;
		}
		
		
	/**
	 * sets pen number 
	 * @param pinNumber - stores pin number
	 */
		public void setPinNumber(int pinNumber) {
			this.pinNumber = pinNumber;
		}

	
		
	}
	