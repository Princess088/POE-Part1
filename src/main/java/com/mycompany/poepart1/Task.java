/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
public class Task {

    //Declarations
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int totalHours;
    private int taskNumber;
    private String taskID;
    private String taskStatus;
    

  

    

    public Task(String taskDescription, int totalHours) {
        // Constructor to initialize a new Task object.
        this.taskDescription = taskDescription; 
        this.totalHours = totalHours;
        this.taskID = generateTaskID(); // Generate a unique ID for the task.
    }

    public boolean checkTaskDescription() {
        // Check if the task description length is within the limit.
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        // Generate a unique task ID using a random number.
        return "TASK-" + (int) (Math.random() * 1000000);
    }

    public String printTaskDetails() {
        // Format and return a string containing the task details.
        return "Task ID: " + taskID + "\n" +
                "Description: " + taskDescription + "\n" +
                "Total Hours: " + totalHours;
    }

    public int returnTotalHours() {
        // Return the total hours spent on the task.
        return totalHours;
    }

    private String generateTaskID() {
        // Generate a unique task ID using a random number.
        return "TASK-" + (int) (Math.random() * 1000000);
    }

    public static void main(String[] args) {
        // Test Data for Task 1
        Task task1 = new Task("This is a task description", 8);
        System.out.println("Task 1 Details:");
        System.out.println(task1.printTaskDetails());
        System.out.println("-----------------------");

        // Test Data for Task 2
        Task task2 = new Task("Another task description", 4);
        System.out.println("Task 2 Details:");
        System.out.println(task2.printTaskDetails());
        System.out.println("-----------------------");
    }

}
    

