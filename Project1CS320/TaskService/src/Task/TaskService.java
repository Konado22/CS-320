package Task; 
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	private static TaskService reference = new TaskService();
	 private final Map<String, Task> tasks;
	public TaskService() {
        this.tasks = new HashMap<String, Task>();
    }
    
   //Create a singleton Task Service
    public static TaskService getService() {
        return reference;
    }
    
    public boolean addTask(Task task) {
        boolean isSuccess = false;
        
        if(!tasks.containsKey(task.getTaskId())) {
            tasks.put(task.getTaskId(), task);
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean deleteTask(String taskId) {
        return tasks.remove(taskId) != null;
    }
    
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
	public void updateTask(Task task) {
			if (tasks.containsKey(task.taskID) ) {
				tasks.put(task.getTaskId(), task);
	}}
}
