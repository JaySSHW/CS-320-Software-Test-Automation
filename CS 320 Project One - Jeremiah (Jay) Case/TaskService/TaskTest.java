package taskservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Four Milestone
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit test for the Task class.
// Verifies all task requirements and validations.
public class TaskTest {
	
	@Test
	void testTaskCreatedSuccessfully() {
		// Create a valid task object
		Task task = new Task("1234567890", "Study", "Complete CS 320 milestone");
		
		// Verify values were stored correctly
		assertEquals("1234567890", task.getTaskId());
		assertEquals("Study", task.getName());
		assertEquals("Complete CS 320 milestone", task.getDescription());
	}
	
	// Verify task ID cannot be null
	@Test
	void testTaskIdCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Study", "Complete assignment");
		});
	}
	
	// Verify task ID cannot exceed 10 characters
	@Test
	void testTaskIdCannotBeLongerThanTenCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Study", "Complete assignment");
		});
	}
	
	// Verify name cannot be null
	@Test
	void testNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Complete assigment");
		});
	}
	
	// Verify name cannot exceed 20 characters
	@Test
	void testNameCannotBeLongerThanTwentyCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "This name is way too long", "Complete assigment");
		});
	}
	
	// Verify description cannot be null
	@Test
	void testDescriptionCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Study", null);
		});
	}
	
	// Verify description cannot exceed 50 characters
	@Test
	void testDescriptionCannotBeLongerThanFiftyCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Study", "This description is longer than fifty characters and should fail.");
		});
	}
	
	// Verify task name can be updated successfully
	@Test
	void testSetNameSuccessfully() {
		Task task = new Task("12345", "Study", "Complete assignment");
		
		task.setName("Homework");
		
		assertEquals("Homework", task.getName());
	}
	
	// Verify task description can be updated successfully
	@Test
	void testSetDescriptionSuccessfully() {
		Task task = new Task("12345", "Study", "Complete assignment");
		
		task.setDescription("Complete Module Four");
		
		assertEquals("Complete Module Four", task.getDescription());
	}

}
