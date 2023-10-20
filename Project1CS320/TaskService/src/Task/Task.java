package Task;	
//classes stored in task package

public class Task {	
	String taskID;
	String name;
	String description;
	//set variables for class
	
	
	public Task(String taskID, String name, String description) {
		
		if (taskID.length() != 10 || taskID == null) {
			throw new IllegalArgumentException("task id error");
		}
		
		if (name.length() > 20 ||name == null) {			
			throw new IllegalArgumentException("task name error");			
		}	
		
		if (description.length() > 50 || description == null) {
			
			throw new IllegalArgumentException("task description error");
		}
		
		this.taskID = taskID;
		this.name = name;
		this.description = description;
		
	}
	//constructor method with error handling per requirements
	public String getTaskId () {
		return taskID;
	}
	public String getName () {
		return name;
	}
	void setName(String name) {
		if (name.length() <= 20 || name != null) {
			this.name = name;
		}
	}
	public String getDescription() {
		return description;
	}
	void setDescription(String description) {
		if (description.length() <= 50 || name != null) {
			this.description = description;
		}
	}
}
