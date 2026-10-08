import models.AdminUser;
import models.RegularUser;

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

    }
}