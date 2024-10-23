/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poepart1;

 import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    void testSetTaskDetails_ValidDescription() {
        // Arrange
        String taskName = "Login Feature";
        String taskDescription = "Create Login to authenticate users.";
        String developerDetails = "Robyn Harrison";
        int duration = 8;
        String taskStatus = "To Do";

        // Act
        task.setTaskDetails(taskName, taskDescription, developerDetails, duration, taskStatus);

        // Assert
        assertTrue(task.checkTaskDescription(), "Task successfully ");
        assertEquals("Lo:0:son", task.createTaskID(), "Task ID should match the expected format.");
        assertEquals(8, task.getTaskDuration(), "Task duration should be 8 hours.");
        assertEquals("To Do", task.getFullTaskDetails().split("\n")[0].split(": ")[1]);
    }

    @Test
    void testSetTaskDetails_InvalidDescription() {
        // Arrange
        String taskName = "Add Task Feature";
        String taskDescription = "Create add task feature to add task users."
                + "To implement an \"Add Task\" feature for users, "
                + "we can design a user-friendly interface that allows team members to easily create new tasks. "
                + "This feature will prompt users to enter essential details such as the task name, description, developer information, estimated duration, and current status. "
                + "By streamlining the task creation process, we ensure that users can quickly add tasks without confusion. Additionally, incorporating validation checks will prevent the submission of incomplete or invalid data, such as overly long descriptions. "
                + "Once a task is added, it will automatically generate a unique task ID for tracking purposes. This feature aims to enhance team collaboration and improve project management efficiency by ensuring that every task is clearly defined and easily accessible to all team members.";
        String developerDetails = "Mike smith";
        int duration = 10;
        String taskStatus = "Doing";

        // Act
        task.setTaskDetails(taskName, taskDescription, developerDetails, duration, taskStatus);

        // Assert
        assertFalse(task.checkTaskDescription(), "Please enter a task description of less than 50 characters");
    }
}
