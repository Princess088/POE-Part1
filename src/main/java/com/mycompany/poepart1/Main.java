/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RC_Student_lab
 */
public class Main {
     private List<Task> tasks = new ArrayList<>();
     private String[] developers;
     private String[] taskNames;
     private String[] taskIDs;
     private int[] taskDurations;
     private String[] taskStatuses;



    public void addTask(Task task) {
        tasks.add(task);
        updateTaskArrays();
    }
    
    private void updateTaskArrays(){
          int size = tasks.size();
        developers = new String[size];
        taskNames = new String[size];
        taskIDs = new String[size];
        taskDurations = new int[size];
        taskStatuses = new String[size];

        for (int i = 0; i < size; i++) {
            Task t = tasks.get(i);
            developers[i] = t.getDeveloper();
            taskNames[i] = t.getTaskName();
            taskIDs[i] = t.createTaskID();
            taskDurations[i] = t.getTaskDuration();
            taskStatuses[i] = t.getTaskStatus();
        }
    }

    public void displayTasksWithStatusDone() {
        StringBuilder report = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < tasks.size(); i++) {
            if (taskStatuses[i].equalsIgnoreCase("Done")) {
                report.append("Developer: ").append(developers[i])
                      .append(", Task Name: ").append(taskNames[i])
                      .append(", Duration: ").append(taskDurations[i]).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
 public void displayLongestTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }
        JOptionPane.showMessageDialog(null, "Longest Task:\n" + longestTask.getFullTaskDetails(), "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }

    public Task findTaskByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task;
            }
        }
        return null;
    }

    public void searchTaskByName(String taskName) {
        Task task = findTaskByName(taskName);
        if (task != null) {
            JOptionPane.showMessageDialog(null, "Task Name: " + task.getTaskName() +
            "\nDeveloper: " + task.getDeveloper() +
                    "\nStatus: " + task.getTaskStatus());
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    public void searchTasksByDeveloper(String developer) {
        StringBuilder report = new StringBuilder("Tasks assigned to " + developer + ":\n");
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                report.append("Task Name: ").append(taskNames[i])
                      .append(", Status: ").append(taskStatuses[i]).append("\n");
                found = true;
            }
        }
        if (!found) {
            report.append("No tasks found for this developer.");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public void deleteTask(String taskName) {
        tasks.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
        updateTaskArrays();
    }
    public void displayReport() {
    if (tasks.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No tasks available to display in the report.");
    } else {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (Task task : tasks) {
            report.append(task.getFullTaskDetails()).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}
    
    public void displayTasksByStatus(String status) {
    StringBuilder report = new StringBuilder("Tasks with status '" + status + "':\n");
    boolean found = false;
    for (int i = 0; i < tasks.size(); i++) {
        if (taskStatuses[i].equalsIgnoreCase(status)) {
            report.append("Developer: ").append(developers[i])
                  .append(", Task Name: ").append(taskNames[i])
                  .append(", Duration: ").append(taskDurations[i]).append(" hours\n");
            found = true;
        }
    }
    if (!found) {
        report.append("No tasks found with the status '" + status + "'.");
    }
    JOptionPane.showMessageDialog(null, report.toString());
}

            
            
    public static void main(String[] args ){
        //Create an object for scanner
        Scanner scanner = new Scanner(System.in);
        
        Login login = new Login();
        
         Main mainApp = new Main();
        
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
        
     
        String result = login.registerUser(username, password);
        System.out.print(result);
        //System.out.print(login.registerUser());
        
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
        String menu = "Select an option:\n" +
                          "1. Add tasks\n" +
                          "2. Show Report\n" +
                          "3. Show tasks by status\n" +
                          "4. Show longest task\n" +
                          "5. Search for a task by name\n" +
                          "6. Search for tasks assigned to a developer\n" +
                          "7. Delete a task\n" +
                          "8. Display tasks with status 'Done'\n" +
                          "9. Quit";

        //int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "***Main Menu***", JOptionPane.QUESTION_MESSAGE));
        
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
        mainApp.addTask(task);
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
            //JOptionPane.showMessageDialog(null, "Coming Soon!");
            mainApp.displayReport();
          break;
           case 3:
                     String status = JOptionPane.showInputDialog(null, "Enter status (To Do / Doing / Done):", "Filter by Status", JOptionPane.QUESTION_MESSAGE);
                    mainApp.displayTasksByStatus(status);
                    break;
                    
                case 4:
                    mainApp.displayLongestTask();
                    break;
                case 5:
                    String taskNameToSearch = JOptionPane.showInputDialog("Enter task name to search:");
                    mainApp.searchTaskByName(taskNameToSearch);
                    break;

            case 6:
                 String developerToSearch = JOptionPane.showInputDialog("Enter developer name to search:");
                    mainApp.searchTasksByDeveloper(developerToSearch);
                    break;
                            case 7:
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter task name to delete:");
                    mainApp.deleteTask(taskNameToDelete);
                    JOptionPane.showMessageDialog(null, "Task deleted if it existed.");
                    break;
                            case 8:
                    mainApp.displayTasksWithStatusDone();
                    break;
                            case 9:
            // Quit application
            loggedIn = false;
            JOptionPane.showMessageDialog(null, "Logged out successfully.");
          break;
        default:
             JOptionPane.showMessageDialog(null, "Invalid option.");
            }
       
    
       for(Task task : tasks){
            task.getTaskDuration();
       
                    }
        
       dialog.dispose();
       
       
        
    
    }
}

}