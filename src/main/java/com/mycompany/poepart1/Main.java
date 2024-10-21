/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
        public class Main {
    public static void main(String[] args ){
        //Create an object for scanner
        Scanner scanner = new Scanner(System.in);

        //Prompt the user to enter their details
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        //An object for Login
        Login login = new Login(username, password, firstName, lastName);
        System.out.print(login.registerUser());
        
        //Method for the user to log in with after being registered
        System.out.print("Login with username:");
        String inputUsername = scanner.next();
        System.out.print("Login with password:");
        String inputPassword = scanner.next();
        
        //Implementation of method above
        boolean loginSuccess = login.loginUser(inputUsername, inputPassword);
        System.out.println(login.returnLoginStatus(loginSuccess));
        
                // Initialize variables
        int numTasks = 0;
        Task[] tasks = new Task[numTasks];
        int totalHours = 0;
        boolean loggedIn = false;

        // Login prompt
        if (loginSuccess) {
            loggedIn = true;
        }

        
        while (loggedIn) {
            // Display welcome message
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

        // Display menu options
        String menu =   "Select an option:\n" +
                      "1. Add tasks\n" +
                      "2. Show Report\n" +
                      "3. Quit";
        int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (choice) {
            case 1:
               //Prompt the user to enter the number of tasks
                numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        tasks = new Task[numTasks];

        //Add tasks
        for (int i = 0; i < numTasks; i++) {
            // Prompt the user to enter task details
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));
            
           // Task status selection
           String[] taskStatusOptions = {"To Do", "Doing", "Done"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select Task Status", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, taskStatusOptions, taskStatusOptions[2]);
            String taskStatus = taskStatusOptions[statusChoice];
              
        // Create task object
        Task task = new Task(taskName, taskDescription, developerDetails, taskDuration,taskStatus);
        // Display report with all task details
        JOptionPane.showMessageDialog(null, task.getFullTaskDetails());
        System.out.println("Task successfully captured.");


        // Validate task description
        if (task.checkTaskDescription()) {
            //Create and array for task
            tasks[i] = task;
            // Display task details
            JOptionPane.showMessageDialog(null, task.createTaskID());
            //Write the total hours-
            totalHours += task.getTaskDuration();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            }
        }
          break;
        case 2:
            // Display report message
            JOptionPane.showMessageDialog(null, "Coming Soon!");
          break;
        case 3:
            // Quit application
            loggedIn = false;
            JOptionPane.showMessageDialog(null, "Logged out successfully.");
          break;
        default:
            
            }
       
    
       for(Task task : tasks){
            task.getTaskDuration();
        }
        
        // Display total hours
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
    }
}
        }
   
