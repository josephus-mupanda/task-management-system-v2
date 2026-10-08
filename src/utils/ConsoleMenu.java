package utils;

import models.Project;
import services.ProjectService;
import services.ReportService;
import services.TaskService;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner;
    private final ProjectService projectService;
    private final TaskService taskService;
    private final ReportService reportService;

    public ConsoleMenu(
            Scanner scanner,
            ProjectService projectService,
            TaskService taskService,
            ReportService reportService
    ) {
        this.scanner = scanner;
        this.projectService = projectService;
        this.taskService = taskService;
        this.reportService = reportService;
    }

    public void start() {

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = ValidationUtils.readInt(
                    scanner,
                    "Choose an option: "
            );

            switch (choice) {

                case 1:
                    projectService.displayProjects();
                    break;

                case 2:
                    taskMenu();
                    break;

                case 3:
                    reportService.displayProjectReport();
                    break;

                case 4:
                    System.out.println(
                            "User switching will be implemented later."
                    );
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1-5."
                    );
            }
        }
    }

    private void displayMainMenu() {

        System.out.println("\n==============================================");
        System.out.println("       JAVA PROJECT MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("Current User: Admin User");
        System.out.println("----------------------------------------------");
        System.out.println("1. Manage Projects");
        System.out.println("2. Manage Tasks");
        System.out.println("3. View Status Reports");
        System.out.println("4. Switch User");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------------");
    }

    private void taskMenu() {

        boolean running = true;

        while (running) {

            System.out.println("\n==============================================");
            System.out.println("              TASK MANAGEMENT");
            System.out.println("==============================================");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Back");
            System.out.println("----------------------------------------------");

            int choice = ValidationUtils.readInt(
                    scanner,
                    "Choose an option: "
            );

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    updateTaskStatus();
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1-4."
                    );
            }
        }
    }

    private void addTask() {

        int projectId = ValidationUtils.readInt(
                scanner,
                "Enter project ID: "
        );

        Project project = projectService.findProject(projectId);

        if (project == null) {
            System.out.println("Project not found.");
            return;
        }

        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        if (taskName.trim().isEmpty()) {
            System.out.println("Task name cannot be empty.");
            return;
        }

        String status = ValidationUtils.readStatus(scanner);

        boolean added = taskService.addTask(
                project,
                taskName,
                status
        );

        if (added) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println(
                    "A task with this name already exists in the project."
            );
        }
    }

    private void viewTasks() {

        int projectId = ValidationUtils.readInt(
                scanner,
                "Enter project ID: "
        );

        Project project = projectService.findProject(projectId);

        if (project == null) {
            System.out.println("Project not found.");
            return;
        }

        taskService.displayTasks(project);
    }

    private void updateTaskStatus() {

        int projectId = ValidationUtils.readInt(
                scanner,
                "Enter project ID: "
        );

        Project project = projectService.findProject(projectId);

        if (project == null) {
            System.out.println("Project not found.");
            return;
        }

        int taskId = ValidationUtils.readInt(
                scanner,
                "Enter task ID: "
        );

        String status = ValidationUtils.readStatus(scanner);

        boolean updated = taskService.updateTaskStatus(
                project,
                taskId,
                status
        );

        if (updated) {
            System.out.println(
                    "Task status updated successfully."
            );
        } else {
            System.out.println("Task not found.");
        }
    }
}