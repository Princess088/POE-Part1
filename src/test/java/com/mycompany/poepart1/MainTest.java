/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author RC_Student_lab
 */

public class MainTest {
    private Main main;

    @Before
    public void setUp() {
        main = new Main();

        // Add sample tasks for testing
        main.addTask(new Task("Mike Smith", "Create Login", 5, "To Do"));
        main.addTask(new Task("Edward Harrison", "Create Add Features", 8, "Doing"));
        main.addTask(new Task("Samantha Paulson", "Create Reports", 2, "Done"));
        main.addTask(new Task("Glenda Oberholzer", "Final Integration", 11, "To Do"));
    }

    @Test
    public void testDisplayTasksWithStatusDone() {
        // Assuming the JOptionPane can be mocked or is tested indirectly through other means
        main.displayTasksWithStatusDone();
    }

    @Test
    public void testDisplayLongestTask() {
        main.displayLongestTask();
    }

    @Test
    public void testFindTaskByName() {
        Task foundTask = main.findTaskByName("Create Login");
        assertNotNull("Expected to find a task named 'Create Login'", foundTask);
        assertEquals("Developer is incorrect for the found task", "Mike Smith", foundTask.getDeveloper());

        Task notFoundTask = main.findTaskByName("Nonexistent Task");
        assertNull("Expected no task found for 'Nonexistent Task'", notFoundTask);
    }

    @Test
    public void testSearchTaskByName() {
        main.searchTaskByName("Create Login");
        main.searchTaskByName("Nonexistent Task");
    }

    @Test
    public void testSearchTasksByDeveloper() {
        main.searchTasksByDeveloper("Samantha Paulson");
        main.searchTasksByDeveloper("Nonexistent Developer");
    }

    @Test
    public void testDeleteTask() {
        main.deleteTask("Create Reports");
        Task deletedTask = main.findTaskByName("Create Reports");
        assertNull("Expected task 'Create Reports' to be deleted", deletedTask);
    }

    @Test
    public void testDisplayReport() {
        main.displayReport();
    }

    @Test
    public void testDisplayTasksByStatus() {
        main.displayTasksByStatus("To Do");
        main.displayTasksByStatus("Nonexistent Status");
    }
}
