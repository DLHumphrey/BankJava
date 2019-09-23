package edu.pitt.BankHuphrey2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is designed to read, create and store different bank accounts.
 * 
 * @author David Humphrey
 * @version 1
 */
public class Bank {
	// stores a list of all checking accounts
	ArrayList<CheckingsAccount> checkingAcc = new ArrayList<CheckingsAccount>();
	// stores a list of all savings account information 
	ArrayList<SavingsAccount> savingsAcc = new ArrayList<SavingsAccount>();
	
	/**
	 * returns list of checking accounts
	 * @return
	 */
	public ArrayList<CheckingsAccount> getCheckingAcc() {
		return checkingAcc;
	}
	/**
	 * returns list of savings accounts
	 * @return
	 */
	public ArrayList<SavingsAccount> getSavingsAcc() {
		return savingsAcc;
	}
	
	public String[] authenticateUserPin( int pinNum){
		ArrayList<String> tempMatchedAccounts = new ArrayList<String>();
		String[] matchedAccountNums;
		for(CheckingsAccount checkingsAcct : checkingAcc ){
			if(checkingsAcct.getPinNumber() == pinNum){
				tempMatchedAccounts.add(String.valueOf(checkingsAcct.getAccountNum()));
			}
		}
		
		for(SavingsAccount savingsAcct : savingsAcc ){
			if( savingsAcct.getPinNumber() == pinNum){
				tempMatchedAccounts.add(String.valueOf(savingsAcct.getAccountNum()));
			}
		}
				
				matchedAccountNums= new String[tempMatchedAccounts.size()];
				matchedAccountNums = tempMatchedAccounts.toArray(matchedAccountNums);
				
				return matchedAccountNums;
	
	}
	
	public Account findSavingsAccount(long accountNumber){
		for(SavingsAccount savingsAcct : savingsAcc){
			if(savingsAcct.getAccountNum() == accountNumber){
				return savingsAcct;
			}
		}
		return null;
	}
	
	public Account findCheckingsAccount(long accountNumber){
		for(CheckingsAccount checkAcct : checkingAcc){
			if(checkAcct.getAccountNum() == accountNumber){
				return checkAcct;
			}
		}
		return null;
	}
	
	
	/**
	 * Creates a new account and stores information into appropriate accounts
	 * @param accountType -stores account type info
	 * @param initBal -storees initial balance
	 * @param accountNum -stores the account number
	 * @param lName -stores the last name 
	 * @param mInit -store name
	 * @param fName -stores name
	 * @param doB -stores date of birth
	 * @param address -stores address of account
	 * @param userrType -stores user type for account owner
	 * @param ssn stores -social security of owner
	 */
	public void createAccount (String accountType, double initBal, long accountNum, String lName, String mInit, String fName, String doB, Address address, String userrType, int ssn, int pinNum){
		
		/*
		 * The if statement below checks and stores account information into appropriate accounts
		 */
		if(accountType.equalsIgnoreCase("Checking")){
			//creates new  checking account
			CheckingsAccount checkAcc = new CheckingsAccount(accountNum, initBal);
			//stores pin number
			checkAcc.setPinNumber(pinNum);
			// adds new created account to list of accounts
			checkingAcc.add(checkAcc);
		}
		else if (accountType.equalsIgnoreCase("Savings")){
			//creates new savings account
			SavingsAccount savAcc = new SavingsAccount(accountNum, initBal);
			//stores pin number
			savAcc.setPinNumber(pinNum);
			// adds new created account to list of accounts
			savingsAcc.add(savAcc);
		}
		else{
			
			System.out.println("No account chosen");
		}
		
	}
	
	
	/**
	 * Used to store names of previously created accounts. stored in a different file
	 */
	private void readAccountsFromFile() {

		// Neeed to access the text file 'Accounts'
		String fileName = "AccountList.txt";

		// Will pull one line at a time from 'Accounts'
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Creates a new BufferedReader from te file reader instance
			BufferedReader buffReader = new BufferedReader(fileReader);
			
			
			/* The BELOW While loop:
			 * Will split the inputed line from file and use comma to separate
			 * then it will create a new account and store in account info in the new account 
			 * and add it to the list of accounts
			 * 
			 */
			while ((line = buffReader.readLine()) != null) {
				
				
				
				String[] accountInfo = line.split(",");
				
				//checks list of accounts and stores only checking accounts
				if(accountInfo[10].equalsIgnoreCase("Checking")){
					CheckingsAccount checkAcc = new CheckingsAccount(Long.parseLong(accountInfo[7])
							,Double.parseDouble(accountInfo[8]));
					checkAcc.setPinNumber(Integer.parseInt(accountInfo[9]));
					checkAcc.setAccountType(accountInfo[10]);
					// adds checking accounts to checking list 
					checkingAcc.add(checkAcc);
					
				}
				//checks list of account and stores only savings account information
				else if(accountInfo[10].equalsIgnoreCase("Savings")){
					SavingsAccount savAcc = new SavingsAccount(Long.parseLong(accountInfo[7])
							,Double.parseDouble(accountInfo[8]));
					savAcc.setPinNumber(Integer.parseInt(accountInfo[9]));
					savAcc.setAccountType(accountInfo[10]);
				//adds savings accounts to savings account list	
				savingsAcc.add(savAcc);
				}		
			}

			// closed the reader. ALWAYS NEEDED 
			buffReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: Unable to open file,'" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("ERROR: Unable to read file, '" + fileName + "'");
		}
	}


	/**
	 * Reads account information from file every time bank a bank is created
	 */
	public Bank(){
		readAccountsFromFile();
	}
	


}
