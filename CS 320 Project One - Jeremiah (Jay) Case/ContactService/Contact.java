package contact;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Three Milestone
 */

//Contact class stores all information for a single contact
public class Contact {
	
	//Contact ID cannot be changed after creation
	private final String contactID;
	
	//Contact fields that can be updated
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	/**
	 * Constructor used to create a contact object
	 * 
	 * @param contactID
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param address
	 */
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// Validate contact ID
		if (contactID == null || contactID.length() > 10) {
		throw new IllegalArgumentException("Invalid contrct ID");
	}
		
		// Set contact ID
		this.contactID = contactID;
		
		// Use setter methods for validation
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	/**
	 * Returns the contact ID
	 * 
	 * @return contactID
	 */
	public String getContactID() {
		return contactID;
}
	/**
	 * Returns first name
	 * 
	 * @param firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Updates first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		// First name cannot be null or longer than 10 characters
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		this.firstName = firstName;
	}
	
	/**
	 * Returns last name
	 * @return lastname
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Updates last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		
		// Last name cannot be null or longer than 10 characters
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	/**
	 * Returns phone number
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Updates phone number
	 * @param phone
	 */
	public void setPhone(String phone) {
		
		//Phone number must be exctly 10 digits
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}
	
	/**
	 * Returns address
	 * @param address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Updates address
	 * @param address
	 */
	public void setAddress(String address) {
		//Address cannot be null or longer than 30 characters
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.address = address;
	}
	}
