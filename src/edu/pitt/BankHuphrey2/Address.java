package edu.pitt.BankHuphrey2;

/**
 * 
 * @author David Humphrey
 *
 */
public class Address {

	// store adress
	private String address1;
	//store second address ( OPTIONAL)
	private String address2;
	// Store the city name 
	private String city;
	// store the state name
	private String state;
	//store the zip code
	private int zip;
	
	/**
	 * stores the address
	 * @param add1
	 * @param add2
	 * @param cit
	 * @param stat
	 * @param zipp
	 */
	public Address( String add1, String add2, String cit, String stat, int zipp){
		// BELOW: stores arguements into veriable above
		address1 = add1;
		address2 = add2;
		city = cit;
		state = stat;
		zip = zipp;
	}
	
	
	/**
	 * returns address
	 * @return
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * returns address
	 * @return
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 *  returns city
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * returns state
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @return
	 */
	public int getZip() {
		return zip;
	}
	
}
