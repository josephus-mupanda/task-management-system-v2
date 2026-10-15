import models.AdminUser;
import models.HardwareProject;
import models.Project;
import models.RegularUser;
import models.SoftwareProject;
import models.Task;
import models.User;
import services.ProjectService;
import services.ReportService;
import services.TaskService;
import utils.ConsoleMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProjectService projectService = new ProjectService();
        TaskService taskService = new TaskService();
        ReportService reportService = new ReportService(projectService);

        User alice = new AdminUser("Admin", "admin@gmail.com");
        User bob = new RegularUser("Josephus Mupanda", "josephus@gmail.com");

        Project alpha = new SoftwareProject(
                "Alpha Tracker", "Task tracking app for startups", 15000, 5, "Java");
        Project sensorKit = new HardwareProject(
                "IoT Sensor Kit", "Sensor prototype for smart devices", 10000, 3, "Sensor board");
        Project smartHouse = new SoftwareProject(
                "Smart House System", "Home automation management system", 50000, 5, "Java and MQTT");
        Project gateway = new HardwareProject(
                "Security Gateway", "IoT security device", 30000, 4, "Network gateway");
        Project inventory = new SoftwareProject(
                "Inventory Manager", "Inventory management application", 20000, 4, "Java");

        projectService.addProject(alpha);
        projectService.addProject(sensorKit);
        projectService.addProject(smartHouse);
        projectService.addProject(gateway);
        projectService.addProject(inventory);

        taskService.addTask(alpha, "Design Database", Task.Status.COMPLETED);
        taskService.addTask(alpha, "Implement API", Task.Status.IN_PROGRESS);
        taskService.addTask(alpha, "Write Unit Tests", Task.Status.PENDING);
        taskService.addTask(sensorKit, "Build Prototype", Task.Status.COMPLETED);
        taskService.addTask(sensorKit, "Calibrate Sensors", Task.Status.PENDING);

        alpha.addMember(bob);
        taskService.assignTask(alpha, alpha.getTasks()[1].getId(), bob);

        Scanner scanner = new Scanner(System.in);

        ConsoleMenu menu = new ConsoleMenu(
                scanner,
                projectService,
                taskService,
                reportService,
                new User[]{alice, bob}
        );

        menu.start();

        scanner.close();
    }
}
