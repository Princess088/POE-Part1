/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int duration;
    private String taskID;
    private String taskStatus;
    private static int taskCounter = 0;
    

    //Initialize declarations
     public void setTaskDetails(String taskName, String taskDescription, String developerDetails, int duration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.duration = duration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        taskCounter++;
    }
    
    //Checks if the task description is less than 50 characters; return true if the description is valid, false otherwise.//
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
  //Creates a unique task ID based on task name and developer details ;return the generated task ID.
    public String createTaskID() {
        return taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3);
    }
  //Returns the task duration;return the task duration in hours.
    public int getTaskDuration() {
        return duration; 
    }
    
     // Get full task details
    public String getFullTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + duration + " hours";
    }
}

