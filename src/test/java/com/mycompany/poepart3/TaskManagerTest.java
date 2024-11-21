package com.mycompany.poepart3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager(10); // Initialize TaskManager with capacity
        taskManager.addTask("Create Login", 1, "Create Login to authenticate users", "Mike Smith", 5, "To Do");
        taskManager.addTask("Create Add Features", 2, "Create Add Features to improve user experience", "Edward Harrison", 8, "Doing");
        taskManager.addTask("Create Reports", 3, "Generate detailed reports", "Samantha Paulson", 2, "Done");
        taskManager.addTask("Add Arrays", 4, "Add support for array manipulation", "Glenda Oberholzer", 11, "To Do");
    }

    @Test
    public void displayTaskWithLongestDuration() {
        String expected = "Developer: Glenda Oberholzer, Duration: 11.0 hours";
        String actual = taskManager.displayTaskWithLongestDuration();
        assertEquals(expected, actual, "Longest task duration mismatch.");
    }

    @Test
    public void searchTaskByName() {
        String expected = "Task Name: Create Login, Developer: Mike Smith";
        String actual = taskManager.searchTaskByName("Create Login");
        assertEquals(expected, actual, "Task search by name failed.");
    }

    @Test
    public void searchTasksByDeveloper() {
        String expected = "Task Name: Create Reports";
        String actual = taskManager.searchTasksByDeveloper("Samantha Paulson");
        assertEquals(expected, actual, "Task search by developer failed.");
    }

    @Test
    public void deleteTaskByName() {
        String expected = "Entry \"Create Reports\" successfully deleted.";
        String actual = taskManager.deleteTaskByName("Create Reports");
        assertEquals(expected, actual, "Task deletion failed.");
    }

    @Test
    public void displayReport() {
        String expected = 
		"""
                Task Report:
                Task ID: CR:1:IKE
                Task Status: To Do
                Developer Details: Mike Smith
                Task Number: 1
                Task Name: Create Login
                Task Description: Create Login to authenticate users
                Task Duration: 5.0 hours
                
                Task ID: CR:2:ARD
                Task Status: Doing
                Developer Details: Edward Harrison
                Task Number: 2
                Task Name: Create Add Features
                Task Description: Create Add Features to improve user experience
                Task Duration: 8.0 hours
                
                Task ID: CR:3:THA
                Task Status: Done
                Developer Details: Samantha Paulson
                Task Number: 3
                Task Name: Create Reports
                Task Description: Generate detailed reports
                Task Duration: 2.0 hours
                
                Task ID: AD:4:NDA
                Task Status: To Do
                Developer Details: Glenda Oberholzer
                Task Number: 4
                Task Name: Add Arrays
                Task Description: Add support for array manipulation
                Task Duration: 11.0 hours
				
                """;

        String actual = taskManager.displayReport();
        assertEquals(expected, actual, "Task report generation failed.");
    }
}
