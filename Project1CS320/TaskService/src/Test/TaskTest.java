package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Task.Task;

class TaskTest {

	@Test
	void testTask() {
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		assertTrue(newTask.getTaskId().equals("0000000001"));
		assertTrue(newTask.getName().equals("Get Milk From Store"));
		assertTrue(newTask.getDescription().equals("I simply cannot forget the milk."));
	}
	
	@Test
	void testTaskIDFail() {
		Task newTask = new Task("0000000001", "Get Milk From Store", "I simply cannot forget the milk.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0000000001", "I need milk duplicate", "Already exists in system should fail test");
		});
	}
	@Test
	
	void testInvalidID () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task newTask = new Task("12345678911", "Get Milk From Store","Failed test id");
		});
	}
	
	@Test
	
	void testNullID () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task newTask = new Task(null, "Get Milk From Store","Failed test id");
		});
	}
	@Test
	
	void testInvalidName () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task newTask = new Task("1234567890", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","Failed test id");
		});
	}
	@Test
	
	void testNullName () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task newTask = new Task("2222222222", null ,"Failed test id");
		});
	}
	@Test
	
	void testInvalidDescription () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task newTask = new Task(null, "Get Milk From Store","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		});
	}
	@Test
	
	void testNullDescription () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Task newTask = new Task("1234567890", "Get Milk From Store",null);
		});
	}
}
