package services;

import models.Project;
import models.Task;

public class TaskService {
    public Task findTask(Project project, int taskId) {

        for (Task task : project.getTasks()) {

            if (task != null && task.getId() == taskId) {
                return task;
            }
        }

        return null;
    }

    public boolean addTask(
            Project project,
            String taskName,
            String status
    ) {

        for (Task task : project.getTasks()) {

            if (task != null &&
                    task.getName().equalsIgnoreCase(taskName)) {

                return false;
            }
        }

        Task task = new Task(taskName, status);
        project.addTask(task);

        return true;
    }

    public boolean updateTaskStatus(
            Project project,
            int taskId,
            String status
    ) {

        Task task = findTask(project, taskId);

        if (task == null) {
            return false;
        }

        task.setStatus(status);
        return true;
    }

    public void displayTasks(Project project) {

        System.out.println("\n==============================================");
        System.out.println("              PROJECT TASKS");
        System.out.println("==============================================");

        System.out.println("Project: " + project.getName());

        boolean hasTasks = false;

        for (Task task : project.getTasks()) {

            if (task != null) {

                hasTasks = true;

                System.out.printf(
                        "ID: %d | Name: %-25s | Status: %s%n",
                        task.getId(),
                        task.getName(),
                        task.getStatus()
                );
            }
        }

        if (!hasTasks) {
            System.out.println("No tasks found.");
        }
    }
}
