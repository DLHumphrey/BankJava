package edu.pitt.BankHuphrey2;

public class User {
	// stores users address
	@SuppressWarnings("unused")
	private Address userAddress;
	//stpres users ID number
	private int userId = 0;
	//storres users last name
	private String lastName;
	// stores users middle name
	private String middleInit;
	//sotres users first name 
	private String firstName;
	// users date of birth
	private String dob;
	//stores users type 
	private String userType = "Customer";
	//stores social security number
	private int socSecNum;
	
	/**
	 *  used when creating a new user 
	 * @param lName stores last name
	 * @param mInit stores initial
	 * @param fName stores first name 
	 * @param doB stores date of birth
	 * @param address stores address
	 * @param userrType stores user type
	 * @param ssn stores social security number
	 */
	public User (String lName, String mInit, String fName, String doB, Address address, String userrType, int ssn){
		
		 userAddress = address;
		 lastName = lName;
		 middleInit = mInit;
		 firstName = fName;
		 dob = doB;
		 userType = userrType;
		 socSecNum = ssn;
		 
		 
	}
	
	/**
	 * gets user id 
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 *  sets user id 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * gets last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * gets middle initial
	 * @return
	 */
	public String getMiddleInit() {
		return middleInit;
	}
	
	/**
	 * gets first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * gets date of birth
	 * @return
	 */
	public String getDob() {
		return dob;
	}
	
	
	/**
	 * gets user type
	 * @return
	 */
	public String getUserType() {
		return userType;
	}
	
	
	/**
	 * gets soc sec number
	 * @return
	 */
	public int getSocSecNum() {
		return socSecNum;
	}
}
