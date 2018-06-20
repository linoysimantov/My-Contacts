package Model;
/**
 * 
 * @author linoy
 *
 */
public class Contact {

	private String userName;
	private String PhoneNumber;

	/**
	 *  ctor for Contact object
	 * @param userName
	 * @param phoneNumber
	 */
	public Contact() {}
	public Contact( String phoneNumber, String userName) {
		super();
		this.userName = userName;
		PhoneNumber = phoneNumber;
	}
	/**
	 * get userName
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * set userName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * get phoneNumber
	 * @return
	 */
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	/**
	 * set phoneNumber
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Contact [userName=" + userName + ", PhoneNumber=" + PhoneNumber + "]";
	}
	

}
