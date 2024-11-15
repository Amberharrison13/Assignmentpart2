/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.assignmentpart2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    public class TaskTest{

    @Test
    public void testCheckTaskDescription_Success() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(task.getTaskDescription()), "Expected valid task description to return true.");
        System.out.println("Task successfully captured");
    }

    @Test
    public void testCheckTaskDescription_Failure() {
        Task task = new Task("Feature", 0, "This description is way too long to be valid because it exceeds fifty characters!", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription(task.getTaskDescription()), "Expected invalid task description to return false.");
        System.out.println("Please enter a task description of less than 50 characters");
    }

@Test
    public void testCreateTaskID() {
        Task task1 = new Task("Add Task Feature", 1, "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        String expectedID1 = "AD:1:ITH"; // Task ID based on "Add Task Feature" and "Mike Smith"
        assertEquals(expectedID1, task1.createTaskID("Add Task Feature", 1, "Mike Smith"), "Expected task ID to match AD:1:ITH.");

        // Loop through other examples
        for (int i = 0; i < 4; i++) {
            String taskName = "Feature " + i;
            String developer = "User " + i;
            Task task = new Task(taskName, i, "Description for " + taskName, developer, 5, "To Do");
            String expectedTaskID = task.createTaskID(taskName, i, developer);
            System.out.println("Generated Task ID: " + expectedTaskID);
        }
    }
 @Test
    public void testTotalHoursAccumulated() {
        Task[] tasks = {
            new Task("Task 1", 0, "Task description", "Robyn Harrison", 10, "To Do"),
            new Task("Task 2", 1, "Task description", "Mike Smith", 12, "Doing"),
            new Task("Task 3", 2, "Task description", "Alice Brown", 55, "In Progress"),
            new Task("Task 4", 3, "Task description", "Charlie Black", 11, "Done"),
            new Task("Task 5", 4, "Task description", "David White", 1, "To Do")
        };

        double totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.returnTotalHours();
        }

        assertEquals(89, totalHours, "Expected total hours to be 89.");
        System.out.println("Total hours accumulated: " + totalHours);
    }

@Test
    public void testTotalHours_WithAdditionalData() {
        Task[] additionalTasks = {
            new Task("Task A", 0, "Task description", "Developer A", 10, "To Do"),
            new Task("Task B", 1, "Task description", "Developer B", 12, "Doing"),
            new Task("Task C", 2, "Task description", "Developer C", 55, "In Progress"),
            new Task("Task D", 3, "Task description", "Developer D", 11, "Done"),
            new Task("Task E", 4, "Task description", "Developer E", 1, "To Do")
        };

        double totalHours = 0;
        for (Task task : additionalTasks) {
            totalHours += task.returnTotalHours();
        }

        assertEquals(89, totalHours, "Expected total hours to be 89.");
        System.out.println("Total hours accumulated with additional data: " + totalHours);
    }
}
