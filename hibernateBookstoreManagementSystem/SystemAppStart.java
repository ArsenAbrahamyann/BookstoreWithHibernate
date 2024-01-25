package hibernateBookstoreManagementSystem;

import hibernateBookstoreManagementSystem.hibernateImpl.BookManagement;
import hibernateBookstoreManagementSystem.hibernateImpl.CustomerManagement;
import hibernateBookstoreManagementSystem.hibernateImpl.ReportsManagement;
import hibernateBookstoreManagementSystem.hibernateImpl.SalesManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemAppStart {
    private static Scanner sc = new Scanner(System.in);
    private static int choice = 0;

    /**
     * Starts the Bookstore Management System application. It displays a menu to the user and processes their choice
     * by calling the respective service.
     */
    public static void StartApplication() {

        while (true) {
            printManu();
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    BookManagement.start();
                    break;
                case 2:
                    CustomerManagement.start();
                    break;
                case 3:
                    SalesManagement.salesStart();
                    break;
                case 4:
                    ReportsManagement.start();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prints the main menu of the Bookstore Management System.
     */
    public static void printManu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nBookstore Management System " +
                  "\n1. Book ServicesReports " +
                  "\n2. Customer ServicesReports " +
                  "\n3. Sales Processing " +
                  "\n4. Sales Reports " +
                  "\n5. Exit " +
                  "Enter your choice: ");
        System.out.println(sb);
    }

}

