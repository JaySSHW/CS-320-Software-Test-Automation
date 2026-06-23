package contact;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Three Milestone
 */

import java.util.HashMap;
import java.util.Map;

// ContactService manages all contacts in memory
public class ContactService {
	
	// HashMap stores contacts using contact ID as the key
	private final Map<String, Contact> contacts = new HashMap<>();
	
	/**
	 * Adds a new contact
	 * @param contact
	 * @return true if added successfully
	 */
	public boolean addContact(Contact contact) {
		// Prevents null contacts
		if (contact == null) {
			return false;
		}
		
		// Prevents duplicate contact IDs
		if (contacts.containsKey(contact.getContactID())) {
			return false;
		}
		
		// Add contact to HashMap
		contacts.put(contact.getContactID(), contact);
		
		return true;
	}
	
	/**
	 * Deletes a contact using contact ID
	 * @param contactID
	 * @return true if deleted succesfully
	 */
	public boolean deleteContact(String contactID) {
		// remove() returns null if contact does not exist
		return contacts.remove(contactID) != null;
	}
	
	/**
	 * Updates the first name of a contact
	 * @param contactID
	 * @param firstName
	 * @return true if updated successfully
	 */
	public boolean updateFirstName(String contactID, String firstName) {
		// Find contact using contact ID
		Contact contact = contacts.get(contactID);
		
		// Return false if contact does not exist
		if (contact == null) {
			return false;
		}
		
		// Update first name
		contact.setFirstName(firstName);
		
		return true;
	}
	
	/**
	 * Updates the last name of contact
	 * @param contactID
	 * @param lastName
	 * @return true if updated successfully
	 */
	public boolean updatesLastName(String contactID, String lastName) {
		// Find contact using contact ID
		Contact contact = contacts.get(contactID);
		
		// Return false if contact does not exist
		if (contact == null){
			return false;
		}
		
		// Update last name
		contact.setLastName(lastName);
		
		return true;
	}
		/**
		 * Updates the phone number of a contact
		 * @param contactID
		 * @param phone
		 * @return true if updated successfully
		 */
		public boolean updatePhone(String contactID, String phone) {
			// Find contact using contact ID
			Contact contact = contacts.get(contactID);
			
			// Return false if contact does not exist
			if (contact == null) {
				return false;
			}
			
			// Update phone number
			contact.setPhone(phone);
			
			return true;
		}
		
		/**
		 * Updates the address of a contact
		 * @param contactID
		 * @param address
		 * @return true updated successfully
		 */
		public boolean updateAddress(String contactID, String address) {
			// Find contact using contact ID
			Contact contact = contacts.get(contactID);
			
			// Return false if contact does not exist
			if (contact == null) {
				return false;
			}
			
			// Update address
			contact.setAddress(address);
			
			return true;
		}
		
		/**
		 * Return contact object using contact ID
		 * @param contactID
		 * @return Contact object
		 */
		public Contact getContact(String contactID) {
			return contacts.get(contactID);
		}
}
