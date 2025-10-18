import java.util.Scanner;

/**
 * Controller class for the QueueDynamo application
 * It handles user input and manages the operations.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 20 Aug 2025
 */
public class Controller {
    /**
     * Scanner for user input.
     */
    private Scanner scanner;

    /**
     * Manager for handling ride queues.
     */
    private RideQueueManager manager;

    /**
     * Constructor to initialise the Controller with a new Scanner, and other
     * necessary components.
     */
    public Controller() {
        scanner = new Scanner(System.in);
        manager = new RideQueueManager();
    }

    /**
     * Main method to run the Controller.
     * It displays the welcome message, prints the menu, and processes user input
     */
    public void run() {
        showWelcome();
        printMenu();

        boolean running = true;
        while (running) {
            //System.out.println(); //print a blank line for better readability
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: 
                    addStandardGuest();
                    break;
                case 2: 
                    addFastPassGuest();
                    break;
                case 3: 
                    addGoldFastPassGuest();
                    break;
                case 4: 
                    processNextGuest();
                    break;
                case 5: 
                    printStatus();
                    break;
                case 6:
                    printMenu();
                    break;
                case 7: {}
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Goodbye - thank you for using the Queue Dynamo Simulator!");
        scanner.close();
    }

    /**
     * Method to add a standard guest to the standard queue.
     * It prompts the user for the guest's name and calls the manager's method to add the guest.
     */
    private void addStandardGuest() {
        String name = getStringInput("Enter guest name: ");
        boolean success = manager.addStandardGuest(name);
        if(success) {
            System.out.println(name + " added to the standard queue.");
        } else {
            System.out.println("Failed to add " + name + " to the standard queue.");
        }
        System.out.println();
    }
    
    /**
     * Method to add a FastPass guest to the end of the FastPass deque.
     * It prompts the user for the guest's name and calls the manager's method to add the guest.
     */
    private void addFastPassGuest() {
        String name = getStringInput("Enter guest name: ");
        boolean success = manager.addFastPassGuest(name, false);
        if(success) {
            System.out.println(name + " added to the back of FastPass deque.");
        } else {
            System.out.println("Failed to add " + name + " to the back of FastPass deque.");
        }
        System.out.println();
    }

    /**
     * Method to add a Gold FastPass guest to the front of the FastPass deque.
     * It prompts the user for the guest's name and calls the manager's method to add the guest.
     */
    private void addGoldFastPassGuest() {
        String name = getStringInput("Enter guest name: ");
        boolean success = manager.addFastPassGuest(name, true);
        if(success) {
            System.out.println(name + " added to the front of FastPass deque.");
        } else {
            System.out.println("Failed to add " + name + " to the front of FastPass deque.");
        }
        System.out.println();
    }

    /**
     * Method to process the next guest in line.
     * It calls the manager's method to process the next guest.
     */
    private void processNextGuest() {
        manager.processNextGuest();
        System.out.println();
    }

    /**
     * Method to print the current status of the ride queues.
     */
    private void printStatus() {
        manager.printStatus();
        System.out.println();
    }

    /**
     * Method to display the welcome message.
     * It prints the welcome message to the console.
     */
    private void showWelcome() {
        System.out.println("======================[ Queue Dynamo ]========================");
        System.out.println("           Welcome to the Queue Dynamo Simulator!");
        System.out.println("==============================================================");
    }

    /**
     * Method to print the menu options.
     * It displays the available operations to the user.
     */
    private void printMenu() {
        System.out.println("\n--- JavaWorld Ride Queue Manager ---");
        System.out.println("1. Add Standard Guest");
        System.out.println("2. Add FastPass Guest");
        System.out.println("3. Add GoldFastPass Guest");
        System.out.println("4. Process Next Guest");
        System.out.println("5. Print Queues");
        System.out.println("6. Print Menu");
        System.out.println("7. Exit");
        System.out.println();
    }

    /**
     * Helper method to get a string input from the user.
     * 
     * @param prompt The prompt message to display.
     * @return The user input as a string.
     */
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Helper method to get an integer input from the user.
     * It keeps prompting until a valid integer is entered.
     * 
     * @param prompt The prompt message to display.
     * @return The user input as an integer.
     */
    private int getIntInput(String prompt) {
        do {
            System.out.print(prompt);
        } while (!scanner.hasNextInt());
        int v = scanner.nextInt();
        scanner.nextLine();
        return v;
    }
}
