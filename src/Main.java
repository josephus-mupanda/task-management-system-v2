import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Project[] projects = new Project[10];

        projects[0] = new SoftwareProject(
                1,
                "Alpha Tracker",
                "Task tracking application",
                15000,
                5
        );

        projects[1] = new HardwareProject(
                2,
                "IoT Sensor Kit",
                "Sensor prototype for smart devices",
                10000,
                3
        );

        projects[2] = new SoftwareProject(
                3,
                "Smart House System",
                "Home automation management system",
                50000,
                5
        );

        projects[3] = new HardwareProject(
                4,
                "Security Gateway",
                "IoT security device",
                30000,
                4
        );

        projects[4] = new SoftwareProject(
                5,
                "Inventory Manager",
                "Inventory management application",
                20000,
                4
        );

        boolean running  = true;

        while(running){

            System.out.println("\n==============================================");
            System.out.println("       JAVA PROJECT MANAGEMENT SYSTEM");
            System.out.println("==============================================");

            System.out.println("1. Manage Projects");
            System.out.println("2. Manage Tasks");
            System.out.println("3. View Status Reports");
            System.out.println("4. Switch User");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    filterProjects(projects, scanner);
                    break;
                case 2:
                    System.out.println("Task management selected.");
                    break;

                case 3:
                    System.out.println("Status reports selected.");
                    break;

                case 4:
                    System.out.println("User switching selected.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-5.");
            }
        }
        scanner.close();

    }

    public static void displayProjects(Project[] projects) {

        System.out.println("\n==============================================");
        System.out.println("              PROJECT CATALOG");
        System.out.println("==============================================");

        System.out.printf(
                "%-5s %-20s %-12s %-10s %-12s%n",
                "ID", "PROJECT NAME", "TYPE", "TEAM SIZE", "BUDGET"
        );

        System.out.println("----------------------------------------------");

        for (Project project : projects) {

            if (project != null) {

                String type = project instanceof SoftwareProject
                        ? "Software"
                        : "Hardware";

                System.out.printf(
                        "%-5d %-20s %-12s %-10d $%-11.2f%n",
                        project.getId(),
                        project.getName(),
                        type,
                        project.getTeamSize(),
                        project.getBudget()
                );

                System.out.println(
                        "      Description: " + project.getDescription()
                );

                System.out.println("----------------------------------------------");
            }
        }
    }

    public static void filterProjects(Project[] projects, Scanner scanner) {

        System.out.println("\n========== PROJECT FILTER ==========");
        System.out.println("1. View All Projects");
        System.out.println("2. Software Projects Only");
        System.out.println("3. Hardware Projects Only");
        System.out.println("4. Search by Budget Range");
        System.out.print("Choose filter: ");

        int choice;

        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid input.");
            scanner.nextLine();
            return;
        }

        for (Project project : projects) {

            if (project == null) {
                continue;
            }

            boolean show = false;

            if (choice == 1) {
                show = true;

            } else if (choice == 2 && project instanceof SoftwareProject) {
                show = true;

            } else if (choice == 3 && project instanceof HardwareProject) {
                show = true;
            }

            if (show) {
                System.out.printf(
                        "%d | %s | %s | Team: %d | Budget: $%.2f%n",
                        project.getId(),
                        project.getName(),
                        project instanceof SoftwareProject
                                ? "Software"
                                : "Hardware",
                        project.getTeamSize(),
                        project.getBudget()
                );
            }
        }
    }
}