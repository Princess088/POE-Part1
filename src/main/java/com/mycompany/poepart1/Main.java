/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
        public class Main {
    public static void main(String[] args ){
        //Create an object for scanner
        Scanner scanner = new Scanner(System.in);
        
        Login login = new Login();
        
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        //Prompt the user to enter their details
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        login.setFirstName(firstName);
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        login.setLastName(lastName);
        System.out.print("Enter username: ");
        String username = scanner.next();
        login.setUsername(username);
        System.out.print("Enter password: ");
        String password = scanner.next();
        login.setPassword(password);
        
       
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
            
            String taskDescription = "";
            boolean validDescription = false;

            // Loop until a valid description is entered
            while (!validDescription) {
                   taskDescription = JOptionPane.showInputDialog("Enter task description:");
                if (taskDescription.length() <= 50) {
                     validDescription = true;
                } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                            }
                        }
           
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));
            
           // Task status selection
           String[] taskStatusOptions = {"To Do", "Doing", "Done"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select Task Status", "Task Status", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, taskStatusOptions, 
                taskStatusOptions[2]);
            String taskStatus = taskStatusOptions[statusChoice];
              
        
        // Create task object using parameters
        Task task = new Task();
        task.setTaskDetails(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        // Display report with all task details
        JOptionPane.showMessageDialog(null, task.getFullTaskDetails());
        JOptionPane.showMessageDialog(null, "Task successfully captured.");


        
        //Create and array for task
        tasks[i] = task;
        // Display task details
        JOptionPane.showMessageDialog(null, task.createTaskID());
        //Write the total hours-
        totalHours += task.getTaskDuration();
        }
         // Display all task details after the last task is added
        StringBuilder allTasksDetails = new StringBuilder("All Tasks Details:\n");
        for (Task task : tasks) {
        allTasksDetails.append(task.getFullTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, allTasksDetails.toString());
        
        
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
        
        
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
        //JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
        
       dialog.dispose();
        
    
    }
}
        }
        