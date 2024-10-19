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
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private int taskNumber;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
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
        return taskDuration;
    }
}

