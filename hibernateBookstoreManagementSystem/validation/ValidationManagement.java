package hibernateBookstoreManagementSystem.validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationManagement {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Reads and validates a non-empty string input from the user through the console. It displays an error message and
     * prompts for re-entry until a valid non-empty string is provided.
     *
     * @param errorMessage The error message to display for invalid input.
     * @return A valid non-empty string input provided by the user.
     */
    public static String getNonEmptyInput(String errorMessage) {
        String input;
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(errorMessage);
            }
        } while (input.isEmpty());
        return input;
    }


    /**
     * Reads and validates a positive double input from the user through the console. It displays an error message and
     * prompts for re-entry until a valid positive double is provided.
     *
     * @param errorMessage The error message to display for invalid input.
     * @return A valid positive double input provided by the user.
     */
    public static double getPositiveDoubleInput(String errorMessage) {
        double input;
        do {
            try {
                input = Double.parseDouble(sc.nextLine());
                if (input <= 0) {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
                input = -1;
            }
        } while (input <= 0);
        return input;
    }


    /**
     * Reads and validates a non-negative integer input from the user through the console. It displays an error message and
     * prompts for re-entry until a valid non-negative integer is provided.
     *
     * @param errorMessage The error message to display for invalid input.
     * @return A valid non-negative integer input provided by the user.
     */
    public static int getNonNegativeIntInput(String errorMessage) {
        int input;
        do {
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < 0) {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
                input = -1;
            }
        } while (input < 0);
        return input;
    }

    /**
     * Reads and validates an email address input from the user through the console. It displays an error message and
     * prompts for re-entry until a valid email address is provided.
     *
     * @param errorMessage The error message to display for invalid input.
     * @return A valid email address input provided by the user.
     */
    public static String getEmailInput(String errorMessage) {
        String email;
        do {
            email = sc.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println(errorMessage);
            }
        } while (!isValidEmail(email));
        return email;
    }

    /**
     * Validates an email address using a regular expression.
     *
     * @param email The email address to validate.
     * @return {@code true} if the email address is valid, {@code false} otherwise.
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }


    /**
     * This method prompts the user to enter a phone number until a valid one is provided.
     * It uses the isValidPhone method to check the validity of the entered phone number.
     * If the entered phone number is not valid, it prints an error message and continues prompting the user.
     *
     * @param errorMessage
     * @return
     */
    public static String getPhoneInput(String errorMessage) {
        String phone;
        do {
            phone = sc.nextLine().trim();
            if (!isValidPhone(phone)) {
                System.out.println(errorMessage);
            }
        } while (!isValidPhone(phone));
        return phone;
    }


    /**
     * This method checks the validity of a phone number using a regular expression.
     * The regular expression allows for two formats:
     * ten consecutive digits or digits separated by optional dashes, spaces, or both.
     *
     * @param phone
     * @return
     */
    public static boolean isValidPhone(String phone) {
        return phone.matches("^(\\d{10}|\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}[-\\s]?\\d{2})$");
    }
}
