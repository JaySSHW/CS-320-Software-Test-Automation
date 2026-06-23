package appointmentservice;

import java.util.Date;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Five Milestone
 */

// The Appointment class stores appointment information.
public class Appointment {
	
	private final String appointmentID;
	private Date appointmentDate;
	private String description;
	
	// Creates a new appointment and validates all fields.
	public Appointment(String appointmentID, Date appointmentDate, String description) {
		
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		
		if (description == null || description.length() > 50 ) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
}
