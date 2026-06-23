package contact;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Three Milestone
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Unit tests for Contact class
public class ContactTest {
	
	/**
	 * Test successful contact creation
	 */
	@Test
	void testValidContactCreation() {
		// Create valid contact object
		Contact contact = new Contact(
				"12345",
				"John",
				"Smith",
				"1234567890",
				"123 Main Street"
		);
		
		// Verify all values were stored correctly
		assertEquals("12345", contact.getContactID());
		assertEquals("John", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main Street", contact.getAddress());
	}
	
	/**
	 * Test invalid contact ID
	 */
	@Test
	void testInvalidContactID() {
		//Contact ID longer than 10 characters should fail
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact( "12345678901", "John", "Smith", "1234567890", "123 Main Street");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Smith", "1234567890", "123 Main Street");
		});
	}
	
	// Test invalid first name
	@Test
	void testInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "VeryLongName", "Smith", "1234567890", "123 Main Street");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Smith", "1234567890", "123 Main Street");
		});
	}
	
	// Test invalid last name
	@Test
	void testInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "VeryLongLastName", "1234567890", "123 Main Street");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", null, "1234567890", "123 Main Street");
		});
	}
	
	/**
	 * Test invalid phone number
	 */
	@Test
	void testInvalidPhone() {
		// Phone number must be exactly 10 digits
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "12345", "123 Main Street");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "123456789A", "123 Main Street");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", null, "123 Main Street");
		});
	}
	
	// Test invalid address
	@Test
	void testInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "1234567890", "This address is definitely too long");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "1234567890", null);
		});
	}
}

