package com.mycompany.poepart3;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class taskTest1 {
    private List<Task> tasksList;

    @BeforeEach
    public void setUp() {
		tasksList = new ArrayList<>();
		tasksList.add(new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do", 1));
		tasksList.add(new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing", 2));
	}
	

	@Test
	public void checkTaskDescription() {
		Task task = tasksList.get(0);
		String taskDescription = "Login Feature";
		boolean expected = true;
		boolean actual = task.checkTaskDescription(taskDescription);

		assertEquals(expected, actual, "Task Successfully Captured");
	}

    @Test
	public void checkTaskDescriptionFailure() {
		Task task = tasksList.get(0);
		String taskDescription = "a very unnecessarily long description that makes no sense whatsoever";
		boolean expected = false;
		boolean actual = task.checkTaskDescription(taskDescription);

		assertEquals(expected, actual, "Please enter a task description of less than 50 characters");
	}

    @Test
	public void createTaskID() {
		Task task = tasksList.get(0);
        String expected = "LO:0:BYN";
		String actual = task.createTaskID();

		assertEquals(expected, actual);
	}

    @Test
	public void returnTotalHours() {
		Task task1 = tasksList.get(0);
        Task task2 = tasksList.get(1);
        double expected = 18.00;
		double actual = task1.returnTotalHours() + task2.returnTotalHours();
		assertEquals(expected, actual);
	}

}
