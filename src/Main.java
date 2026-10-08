import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Task task = new Task("Implement UI", "Pending");

        System.out.println("Task ID: " + task.getId());
        System.out.println("Task Name: " + task.getName());
        System.out.println("Status: " + task.getStatus());
        System.out.println("Completed: " + task.isCompleted());

        task.setStatus("Completed");

        System.out.println("Updated Status: " + task.getStatus());
        System.out.println("Completed: " + task.isCompleted());

    }
}