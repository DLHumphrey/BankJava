package edu.pitt.BankHuphrey2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class BankUI {

	private JFrame frame;
	private JTextField txtPin;
	private JLabel lblPin;
	private JLabel lblNotification;
	private JLabel lblAccount;
	private JLabel lblAmount;
	private JLabel lblBalance;
	private JLabel lblTransactions;
	private JButton btnLogin;
	private JComboBox cboAccounts;
	private JTextField txtAmount;
	private JButton btnWithdraw;
	private JButton btnDeposit;
	private JTextArea txtBalance;
	private JTextArea txtTransaction;
	private JTextArea txtNotifications;
	 
	Bank bank = new Bank();
	Date date = new Date();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankUI window = new BankUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPin = new JLabel("Pin:");
		lblPin.setBounds(25, 50, 28, 20);
		frame.getContentPane().add(lblPin);
		
		lblNotification = new JLabel("Notification:");
		lblNotification.setBounds(25, 87, 86, 20);
		frame.getContentPane().add(lblNotification);
		
		lblAccount = new JLabel("Account:");
		lblAccount.setBounds(25, 126, 69, 20);
		frame.getContentPane().add(lblAccount);
		
		lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(27, 175, 69, 20);
		frame.getContentPane().add(lblAmount);
		
		lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(25, 225, 69, 20);
		frame.getContentPane().add(lblBalance);
		
		 lblTransactions = new JLabel("Transactions:");
		lblTransactions.setBounds(25, 290, 103, 20);
		frame.getContentPane().add(lblTransactions);
		
		txtPin = new JTextField();
		txtPin.setBounds(126, 47, 146, 26);
		frame.getContentPane().add(txtPin);
		txtPin.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboAccounts.removeAllItems();
				txtTransaction.setText(" ");
				txtBalance.setText(" ");
				txtAmount.setText(" ");
				
				
				int pinNumber = Integer.parseInt(txtPin.getText());
				String[] accountNumberList = bank.authenticateUserPin(pinNumber);
				
					if( accountNumberList.length == 0 ){
						txtNotifications.append("Invalid pin");
						
					}else{
							txtNotifications.setText(" ");
						for(String accountNumber : accountNumberList){
							cboAccounts.addItem(accountNumber);
							
							}	
					}
				
					
			}
		});
		btnLogin.setBounds(298, 46, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		
		txtNotifications = new JTextArea();
		txtNotifications.setEditable(false);
		txtNotifications.setBounds(126, 87, 522, 22);
		frame.getContentPane().add(txtNotifications);
		
		cboAccounts = new JComboBox();
		cboAccounts.setBounds(126, 123, 169, 26);
		frame.getContentPane().add(cboAccounts);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(126, 172, 146, 26);
		frame.getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double amount = Double.parseDouble(txtAmount.getText());
				String selectedAccount = String.valueOf(cboAccounts.getSelectedItem());
				Account withAccount = bank.findCheckingsAccount(Long.parseLong(selectedAccount));
				
				if (withAccount != null ){
					txtBalance.setText(" ");
					txtBalance.append(""+ withAccount.getAccountBal());
					withAccount.withdraw(amount, 35.00);
					txtTransaction.append("Transaction successful on " + date +
							"\n Withdrawal Amount: " + amount + 
							"\n Account Number: " + selectedAccount + 
							"\n Transation Type: " + withAccount.getAccountType() +
							"\n Final Balance: " + withAccount.getAccountBal() );
	
					txtAmount.setText(" ");
					
				}
				else 
				{

					withAccount = bank.findSavingsAccount(Long.parseLong(selectedAccount));
					txtBalance.setText(" ");
					txtBalance.append(""+ withAccount.getAccountBal());
					withAccount.withdraw(amount, 35.00);
					txtTransaction.append("Transaction successful on " + date +
							"\n Withdrawal Amount: " + amount + 
							"\n Account Number: " + selectedAccount + 
							"\n Transation Type: " + withAccount.getAccountType() +
							"\n Final Balance: " + withAccount.getAccountBal() );
					
					txtAmount.setText(" ");
				}
			}
		});
		btnWithdraw.setBounds(298, 171, 115, 29);
		frame.getContentPane().add(btnWithdraw);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double amount = Double.parseDouble(txtAmount.getText());
				String selectedAccount = String.valueOf(cboAccounts.getSelectedItem());
				Account depositAccount = bank.findCheckingsAccount(Long.parseLong(selectedAccount));
				
				if (depositAccount != null ){
					
					txtBalance.append(""+ depositAccount.getAccountBal());
					depositAccount.deposit(amount);//
					txtTransaction.append("Transaction successful on " + date +
							"\n Deposit Amount: " + amount + 
							"\n Account Number: " + selectedAccount + 
							"\n Transation Type: " + depositAccount.getAccountType() +
							"\n Final Balance: " + depositAccount.getAccountBal() );
	
					txtAmount.setText(" ");
					
				}
				else 
				{

					depositAccount = bank.findSavingsAccount(Long.parseLong(selectedAccount));
					txtBalance.append(""+ depositAccount.getAccountBal());
					depositAccount.deposit(amount);//
					txtTransaction.append("Transaction successful on " + date +
							"\n Deposit Amount: " + amount + 
							"\n Account Number: " + selectedAccount + 
							"\n Transation Type: " + depositAccount.getAccountType() +
							"\n Final Balance: " + depositAccount.getAccountBal() );
					
					txtAmount.setText(" ");
				}
			}
		});
		btnDeposit.setBounds(446, 171, 115, 29);
		frame.getContentPane().add(btnDeposit);
		
		txtBalance = new JTextArea();
		txtBalance.setEditable(false);
		txtBalance.setBounds(126, 225, 211, 22);
		frame.getContentPane().add(txtBalance);
		
		txtTransaction = new JTextArea();
		txtTransaction.setEditable(false);
		txtTransaction.setBounds(122, 290, 526, 148);
		frame.getContentPane().add(txtTransaction);
		
		
		
		
	}
}
