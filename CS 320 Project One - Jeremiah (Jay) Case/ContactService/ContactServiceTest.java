package contact;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Three Milestone
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit tests for ContactService class
public class ContactServiceTest {
	/**
	 * Test adding a contact successfully
	 */
	@Test
	void testAddContact() {
		// Create ContactService object
		ContactService service = new ContactService();
		
		// Create valid contact object
		Contact contact = new Contact("12345", "John", "Smith","1234567890", "123 Main Street");
		
		// Verify contact was added successfully
		assertTrue(service.addContact(contact));
	}
	
	/**
	 * Test duplicate contact IDs
	 */
	@Test
	void testDuplicateContactID() {
		
		ContactService service = new ContactService();
		
		// Create first contact
		Contact contact1 = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
		
		// Create second contact with same ID
		Contact contact2 = new Contact("12345", "Jane", "Doe", "1234567890", "123 Main Street");
		
		// First add should succeed
		assertTrue(service.addContact(contact1));
		
		// Second add should fail due to duplicate ID
		assertFalse(service.addContact(contact2));
	}
	
	/**
	 * Test deleting a contact
	 */
	@Test
	void testDeleteContact() {
		
		ContactService service = new ContactService();
		
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
		
		// Add contact first
		service.addContact(contact);
		
		// Verify delete operation succeeds
		assertTrue(service.deleteContact("12345"));
	}
	
	/**
	 * Test updating first name
	 */
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
		
		// Add contact
		service.addContact(contact);
		
		// Update first name
		service.updateFirstName("12345", "Jane");
		
		// Verify update occurred
		assertEquals("Jane", service.getContact("12345").getFirstName());
	}
	
	// Verify updating last name
	@Test
	void testUpdateLastName() {
		
		ContactService service = new ContactService();
		
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
		
		service.addContact(contact);
		
		service.updatesLastName("12345", "Doe");
		
		assertEquals("Doe", service.getContact("12345").getLastName());
	}
	
	// Verify updating phone
	@Test
	void testUpdatePhone() {
		
		ContactService service = new ContactService();
		
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
		
		service.addContact(contact);
		
		service.updatePhone("12345", "0987654321");
		
		assertEquals("0987654321", service.getContact("12345").getPhone());
	}
	
	// Verify updating address
	@Test
	void testUpdateAddress() {
		
		ContactService service = new ContactService();
		
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
		
		service.addContact(contact);
		
		service.updateAddress("12345", "456 Oak Street");
		
		assertEquals("456 Oak Street", service.getContact("12345").getAddress());
	}
}

