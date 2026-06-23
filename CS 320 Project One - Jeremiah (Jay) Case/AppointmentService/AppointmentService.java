package appointmentservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Five Milestone
 */

// The AppointmentService class stores appointment objects and performs operations on appointment records.

import java.util.ArrayList;

public class AppointmentService {
	// Stores appointment objects in memory
	private ArrayList<Appointment> appointments = new ArrayList<>();
	
	/*
	 * Adds a new appointment to the appointment list.
	 * Appointment IDs must be unique.
	 */
	public void addAppointment(Appointment appointment) {
		
		// Check for duplicate appointment IDs
		for (Appointment existingAppointment : appointments) {
			if (existingAppointment.getAppointmentID()
					.equals(appointment.getAppointmentID())) {
				throw new IllegalArgumentException("Appointment ID already exists");
			}
		}
		appointments.add(appointment);
	}
	
	// Deletes an appointment using the appointment ID
	public void deleteAppointment(String appointmentID) {
		
		// Search for matching appointment ID
		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentID().equals(appointmentID)) {
				appointments.remove(appointment);
				return;
			}
		}
		
		throw new IllegalArgumentException("Appointment ID not found");
	}
	
	/*
	 * Returns the list of appointments.
	 * Used primarily for testing purposes
	 */
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

}
