package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

@SuppressWarnings("unused")
class TaskServiceTest {

	@Test
	void testAdd() {
		TaskService taskService = new TaskService();
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		taskService.addTask(newTask);
		Assertions.assertTrue(newTask.getTaskId().equals("0000000001"));
		Assertions.assertTrue(newTask.getName().equals("Get Milk From Store"));
		Assertions.assertTrue(newTask.getDescription().equals("I simply cannot forget the milk."));
	}
	
	@Test
	void testAddFail() {
		TaskService taskService = new TaskService();	
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		taskService.addTask(newTask);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task badTask = new Task("0000000001", "duplicate id", "this test case should fail due to duplicate id");
			taskService.addTask(badTask);
			taskService.getTask(badTask.getTaskId());
		});
		
	}
	
	@Test
	void testUpdate() {
		TaskService taskService = new TaskService();
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		taskService.addTask(newTask);
		Task updateTask = new Task("0000000001", "Info updated", "updated by id");
		taskService.updateTask(updateTask);
		Assertions.assertTrue(taskService.getTask("0000000001").equals(updateTask));
		Assertions.assertTrue(taskService.getTask("0000000001").getName().equals(updateTask.getName()));
		Assertions.assertTrue(taskService.getTask("0000000001").getDescription().equals(updateTask.getDescription())); 
	}
	
	@Test
	void testUpdateFail() {
		TaskService taskService = new TaskService();
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		taskService.addTask(newTask);
		Task updateTask = new Task("0000000002", "Info updated", "updated by id");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.updateTask(updateTask);
		});
	}
	
	@Test
	void testDelete() {
		TaskService taskService = new TaskService();
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		taskService.addTask(newTask);
		taskService.deleteTask("0000000001");
		Assertions.assertTrue(taskService.getTask("0000000001").equals(null));
	}
	
	@Test
	void testDeleteFail() {
		TaskService taskService = new TaskService();
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		taskService.addTask(newTask);
		@SuppressWarnings("unused")
		Task removedTask = new Task("0000000002", "Fails", "This test should fail");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		taskService.deleteTask("0000000002");
	});
	}
}
