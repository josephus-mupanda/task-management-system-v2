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
            System.out.println("\n === Task Management System ===");
            System.out.println("1. View Projects");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");

            int choice =  scanner.nextInt();

            switch (choice){
                case 1:
                    displayProjects(projects);
                    break;
                case 2:
                    System.out.println("Viewing Tasks ...");
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
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
}