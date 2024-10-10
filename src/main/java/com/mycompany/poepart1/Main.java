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
    public static void main(String[] args){
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

                // Get the number of tasks from the user
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

        // Create an array of Task objects to store the tasks
        Task[] tasks = new Task[numTasks];

        // Get the details of each task from the user
        for (int i = 0; i < numTasks; i++) {
            tasks[i] = new Task();
            tasks[i].setTaskName(JOptionPane.showInputDialog("Enter task name:"));
            tasks[i].setTaskDescription(JOptionPane.showInputDialog("Enter task description:"));
            tasks[i].setDeveloperDetails(JOptionPane.showInputDialog("Enter developer name:"));
            tasks[i].setTaskDuration(Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):")));
            tasks[i].setTaskNumber(i);
            tasks[i].setTaskID(tasks[i].createTaskID());
            tasks[i].setTaskStatus(JOptionPane.showInputDialog("Enter task status:"));
            JOptionPane.showMessageDialog(null, tasks[i].toString());
        }

        // Calculate the total hours for all tasks
         int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
  
        while (true) {
            String choice = (String) JOptionPane.showInputDialog(null, "Select an option:", "Menu", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Add tasks", "Show Report", "Quit"}, "Add tasks");
            if (choice.equals("Add tasks")) {
                // Add tasks functionality
            } else if (choice.equals("Show Report")) {
                JOptionPane.showMessageDialog(null, "Coming Soon");
            } else if (choice.equals("Quit")) {
                break;
            
            }
        }
    }
        }
