import models.*;
import services.ProjectService;
import services.ReportService;
import services.TaskService;
import utils.ConsoleMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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

        ProjectService projectService =
                new ProjectService(projects);

        TaskService taskService =
                new TaskService();

        ReportService reportService =
                new ReportService(projects);

        Scanner scanner = new Scanner(System.in);

        ConsoleMenu menu = new ConsoleMenu(
                scanner,
                projectService,
                taskService,
                reportService
        );

        menu.start();

        scanner.close();
    }
}