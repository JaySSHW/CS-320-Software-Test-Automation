package appointmentservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Five Milestone
 */

// Contains JUnit tests for Appointment object creation and validation requirements

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
	
	// Creates a valid future date for testing.
	private Date futureDate() {
		return new Date(System.currentTimeMillis() + 86400000);
	}
	
	// Creates a past date for validation testing.
	private Date pastDate() {
		return new Date(System.currentTimeMillis() - 86400000);
	}
	
	// Verify a valid appointment can be created successfully.
	@Test
	void testAppointmentCreatedSuccessfully() {
		
		Appointment appointment = new Appointment("1234567890", futureDate(), "Doctor appointment");
		
		assertEquals("1234567890", appointment.getAppointmentID());
		
		assertEquals("Doctor appointment", appointment.getDescription());
		
		assertNotNull(appointment.getAppointmentDate());
	}
	
	// Verify appointment ID cannot be null
	@Test
	void testAppointmentIDCannotBeNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate(), "Doctor appointment");
		});
	}
	
	// Verify appointment ID cannnot exceed 10 characters.
	@Test
	void testAppointmentIDCannotBeMongerThanTenCharacters() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", futureDate(), "Doctor appointment");
		});
	}
	
	// Verify appointment data cannot be in the past.
	@Test
	void testAppointmentDateCannotBeInPast() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", pastDate(), "Doctor appointment");
		});
	}
	
	// Verify description cannot be null.
	@Test
	void testDescriptionCannotBeNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", futureDate(), null);
		});
	}
	
	// Verify description cannot exceed 50 characters.
	@Test
	void testDescriptionCannotBeLongerThanFiftyCharacters() {
		
		assertThrows(IllegalArgumentException.class, () -> {
		new Appointment("12345", futureDate(), "This description is longer than fifty charcters and invalid.");
	});
	}
	
	// Verify appointment date can not be null.
	@Test
	void testAppointmentDateCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", null, "Valid description");
		});
	}
}
