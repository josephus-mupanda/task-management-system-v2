import models.*;

public class Main {
    public static void main(String[] args) {

        RegularUser regularUser = new RegularUser(
                "Josephus", "josephus@gmail.com");

        AdminUser adminUser  =  new AdminUser(
                "Admin", "admin@gmail.com");

        System.out.println("Regular User");
        System.out.println("ID: " + regularUser.getId());
        System.out.println("Name: " + regularUser.getName());
        System.out.println("Role: " + regularUser.getRole());

        System.out.println();

        System.out.println("Admin User");
        System.out.println("ID: " + adminUser.getId());
        System.out.println("Name: " + adminUser.getName());
        System.out.println("Role: " + adminUser.getRole());

        SoftwareProject softwareProject =  new SoftwareProject(1,"Smart House", "system ...",2000, 3);
        HardwareProject hardwareProject =  new HardwareProject(2,"IoT", "system ...",3000, 2);

        System.out.println(softwareProject.getProjectDetails());
        System.out.println(hardwareProject.getProjectDetails());

        Task task = new Task(
                1,
                "Create project structure",
                "Set up the Java project"
        );

        System.out.println("Task: " + task.getTitle());
        System.out.println("Completed: " + task.isCompleted());

        task.complete();

        System.out.println("Completed after complete(): " + task.isCompleted());

    }
}