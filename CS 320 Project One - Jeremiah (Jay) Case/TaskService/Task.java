package taskservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Four Milestone
 */

// Task class stores task information for the application.
// Each task contains a unique ID, name, and description.
public class Task {
	
	// Unique task ID that cannot be modified after creation
	private final String taskId;
	// Name of the task
	private String name;
	// Description of the task
	private String description;
	
	
	/*
	 * Constructor creates a new task object and validates
	 * the task ID, name, and description.
	 */
	public Task(String taskId, String name, String description) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// Returns the task ID
	public String getTaskId() {
		return taskId;
	}
	
	// Returns the task name
	public String getName() {
		return name;
	}
	
	// Returns the task description
	public String getDescription() {
		return description;
	}
	
	// Updates the task name after validation
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		this.name = name;
	}
	
	// Updates the task description after validation
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		
		this.description = description;
	}

}
