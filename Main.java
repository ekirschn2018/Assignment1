package com.evelynkirschner.assignment1;

public class Main {

    public static void listMenuOptions(){
        // method to list the Menu Options

        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit");
    }

    public static int getUserOption(){
        // method to get user input

        String numberAsString;
        int userOption;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        listMenuOptions();
        numberAsString = scanner.nextLine();
        userOption = Integer.parseInt(numberAsString);     // Convert string to a integer
        while ( ( userOption < 0 )|| (userOption > 4 ) ) {    // check if input is valid
            System.out.println("You did not enter a valid option.  Try again.");
            listMenuOptions();
            numberAsString = scanner.nextLine();
            userOption = Integer.parseInt(numberAsString);     // Convert string to a integer
        }
        return userOption;
    }

    public static void addTask( String Tasks[], int taskIndex ){
        // method to add a task to the list
        // taskIndex is the next place on the list to add the task

        System.out.println("Enter a description of the task:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String newTask = scanner.nextLine();
        Tasks[taskIndex] = newTask;
    }

    public static int removeTask( String Tasks[], int lastTask ){
        // method to remove a Task from the list.
        // If it is not the last task, we need to move the tasks up

        System.out.println("Enter the number (index) of the task to be removed:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String numberAsString = scanner.nextLine();
        int taskIndex = Integer.parseInt(numberAsString);     // Convert string to a integer
        if ( taskIndex > lastTask ) {       // Check to see if the index is valid
            System.out.println("There is not a task at that index");
            return lastTask;    // no change in the number of tasks
        }
        else if ( (lastTask == 0) || ( taskIndex == lastTask ) ) {  // If removing the last task in the list set it to ""
            Tasks[lastTask] = "";
        }
        else {
            for (int i = taskIndex; i < lastTask; i++) {
                Tasks[i] = Tasks[i + 1];
            }
        }
        lastTask -= 1;
        return lastTask;      // decrement the number of tasks by one
    }

    public static void updateTask( String Tasks[], int lastTask) {
        // method to update a Task in the list.
        // If it
        System.out.println("Enter the number (index) of the task to be updated:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String numberAsString = scanner.nextLine();
        int taskIndex = Integer.parseInt(numberAsString);     // Convert string to a integer
        if ( taskIndex > lastTask )     // Check to see if the index is valid
            System.out.println("There is not a task at that index");
        else {      // Get the new task description
            System.out.println("Enter a new description for the task:");
            String newTask = scanner.nextLine();
            Tasks[taskIndex] = newTask;
        }
    }

    public static void listTasks( String Tasks[], int lastTask) {
        // method to list all of the Tasks so far

        if (lastTask >= 0) {     // if there are tasks on the list
            System.out.println("These are the current tasks in your list");
            for (int i = 0; i <= lastTask; i++){
                System.out.println( "[" + i + "]: " + Tasks[i]);
            }
        }
        else
            System.out.println("Your task list is empty!");
        System.out.println( " " );      // Print an empty line
    }

    public static void main(String[] args) {
        // class to manage a task list
        String[] TaskList = new String[50]; // list of tasks
        int numTasks = -1;
        int userChoice;     // user input from menu
        userChoice = getUserOption();
        while (userChoice != 0){
            switch (userChoice) {
                case 1:         // Add a Task
                    numTasks++;
                    addTask(TaskList, numTasks);
                    break;
                case 2:         // Remove a Task
                    if ( numTasks < 0 )
                        System.out.println( "There are no tasks on the list to remove.");
                    else
                        numTasks = removeTask(TaskList, numTasks);
                    break;
                case 3:         // Update a Task
                    if ( numTasks < 0 )
                        System.out.println( "There are no tasks on the list to update.");
                    else
                        updateTask(TaskList, numTasks);
                    break;
                case 4:         // List Tasks
                    listTasks(TaskList, numTasks);
                    break;
            }
            userChoice = getUserOption();
        }
    }
}
