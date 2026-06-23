package taskservice;

/**
 * Jeremiah (Jay) Case
 * CS-320
 * Module Four Milestone
 */

import java.util.HashMap;
import java.util.Map;

// TaskService manages task objects in memory.
// Tasks can be added, updated, retrieved, and deleted.
public class TaskService {
	// Stores task using the task ID as the key
	private final Map<String, Task> tasks = new HashMap<>();
	
	// Adds a task to the collection
	// Task IDs must be unique
	public void addTask(Task task) {
		if (task == null || tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task already exists or is invalid");
		}
		tasks.put(task.getTaskId(), task);
	}
	
	// Removes a task from the collection using its ID.
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID not found");
		}
		tasks.remove(taskId);
	}
	
	// Updates the name of an existing task.
	public void updateTaskName(String taskId, String name) {
		Task task = tasks.get(taskId);
		
		if (task == null) {
			throw new IllegalArgumentException("Task ID not found");
		}
		task.setName(name);
	}
	
	// Updates the description of an existing task.
	public void updateTaskDescription(String taskId, String description) {
		Task task = tasks.get(taskId);
		
		if (task == null) {
			throw new IllegalArgumentException("Task ID not found");
		}
		task.setDescription(description);
	}
	
	// Returns a task object using its ID.
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}

}
