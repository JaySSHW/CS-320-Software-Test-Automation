package taskservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Four Milestone
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Unit test for the TaskService class.
// Verifies task creation, updates, and deletion.
public class TaskServiceTest {
	
	@Test
	void testAddTaskSuccessfully() {
		// Create service and new task
		TaskService service = new TaskService();
		Task task = new Task("12345", "Study", "Complete milestone");
		
		// Add task to service
		service.addTask(task);
		
		// Verify task was added successfully
		assertEquals(task, service.getTask("12345"));
	}
	
	// Verify duplicate task IDs are rejected
	@Test
	void testCannotAddDuplicateTaskId() {
		TaskService service = new TaskService();
		Task task1 = new Task("12345", "Study", "Complete milestone");
		Task task2 = new Task("12345", "Read", "Read testbook");
		
		service.addTask(task1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
		});
	}
	
	// Verify a task can be deleted successfully
	@Test
	void testDeleteTaskSuccessfully() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Study", "Complete milestone");
		
		service.addTask(task);
		service.deleteTask("12345");
		
		assertNull(service.getTask("12345"));
	}
	
	// Verify exception is thrown when ID does not exist
	@Test
	void testDeleteTaskThatDoesNotExist() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("99999");
		});
	}
	
	// Verify task name can be updated
	@Test
	void testUpdateTaskNameSuccessfully() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Study", "complete milestone");
		
		service.addTask(task);
		service.updateTaskName("12345", "Update Name");
		
		assertEquals("Update Name", service.getTask("12345").getName());
	}
	
	// Verify task description can be updated
	@Test
	void testUpdateTaskDescriptionSuccessfully() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Study", "Complete milestone");
		
		service.addTask(task);
		service.updateTaskDescription("12345", "Update description");
		
		assertEquals("Update description", service.getTask("12345").getDescription());
	}
	
	// Verify updating a missing task throws an exception
	@Test
	void testUpdateTaskNameForMissingTask() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("99999", "New Name");
		});
	}
	
	// Verify updating a missing task throws an exception
	@Test
	void testUpdateTaskDescriptionForMissingTask() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskDescription("99999", "New Description");
		});
	}

}
