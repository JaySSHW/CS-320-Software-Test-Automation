package appointmentservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Five Milestone
 */

// Contains JUnit test that verify appointment service operations and business requirements.

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	// Creates a future date for valid appointment creation.
	private Date futureDate() {
		return new Date(System.currentTimeMillis() + 86400000);
	}
	
	// Verify an appointment can be added successfully.
	@Test
	void testAddAppointmentSuccessfully() {
		
		AppointmentService service = new AppointmentService();
		
		Appointment appointment = new Appointment("12345", futureDate(), "Dentist appointment");
		
		service.addAppointment(appointment);
		
		assertEquals(1, service.getAppointments().size());
		
		assertEquals("12345", service.getAppointments().get(0).getAppointmentID());
	}
	
	// Verify duplicate appointment IDs are rejected.
	@Test
	void testCannotAddDuplicateAppointmentID() {
		
		AppointmentService service = new AppointmentService();
		
		Appointment appointmentOne = new Appointment("12345", futureDate(), "Dentist appointment");
		
		Appointment appointmentTwo = new Appointment("12345", futureDate(), "Doctor appointment");
		
		service.addAppointment(appointmentOne);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointmentTwo);
		});
	}
	
	// Verify an appointment can be deleted successfully.
	@Test
	void testDeleteAppointmentSuccessfully() {
		
		AppointmentService service = new AppointmentService();
		
		Appointment appointment = new Appointment("12345", futureDate(), "Dentist appointment");
		
		service.addAppointment(appointment);
		
		service.deleteAppointment("12345");
		
		assertEquals(0, service.getAppointments().size());
		}
	
	// Verify an exception is thrown when attempting to delete a non existant appointment.
	@Test
	void testDeleteAppointmentNotFound() {
		
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("99999");
		});
	}
}
