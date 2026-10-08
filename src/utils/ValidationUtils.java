package utils;

import java.util.Scanner;

public class ValidationUtils {

    public static int readInt(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    public static String readStatus(Scanner scanner) {

        while (true) {

            System.out.print(
                    "Enter status (Pending/In Progress/Completed): "
            );

            String status = scanner.nextLine();

            if (status.equalsIgnoreCase("Pending")
                    || status.equalsIgnoreCase("In Progress")
                    || status.equalsIgnoreCase("Completed")) {

                return status;
            }

            System.out.println(
                    "Invalid status. Please choose Pending, In Progress, or Completed."
            );
        }
    }
}