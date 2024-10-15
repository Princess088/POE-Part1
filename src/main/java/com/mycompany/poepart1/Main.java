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

               int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

            Task[] tasks = new Task[numTasks];
            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Task();
                String taskName = JOptionPane.showInputDialog("Enter task name:");
                tasks[i].setTaskName(taskName);
                String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                while (taskDescription.length() > 50) {
                    taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
                }
                tasks[i].setTaskDescription(taskDescription);
                String devFirstName = JOptionPane.showInputDialog("Enter developer first name:");
                String devLastName = JOptionPane.showInputDialog("Enter developer last name:");
                tasks[i].setDeveloperDetails(devFirstName + " " + devLastName);
                int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
                tasks[i].setTaskDuration(taskDuration);
                tasks[i].setTaskNumber(i);
                tasks[i].setTaskID(tasks[i].createTaskID());
                String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Done", "Doing"}, "To Do");
                tasks[i].setTaskStatus(taskStatus);
                JOptionPane.showMessageDialog(null, tasks[i].toString());
         }

            int totalHours = 0;
            for (Task task : tasks) {
                totalHours += task.getTaskDuration();
            }
            JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);



        OUTER:
        while (true) {
            String choice = (String) JOptionPane.showInputDialog(null, "Select an option:", "Menu", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Add tasks", "Show Report", "Quit"}, "Add tasks");
            switch (choice) {
            // Add tasks functionality
                case "Add tasks":
                    break;
                case "Show Report":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "Quit":
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
                default:
                     JOptionPane.showMessageDialog(null, "Invalid choice", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
        }
