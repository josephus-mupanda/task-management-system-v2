package services;

import models.Project;
import models.Task;
import models.User;
import utils.ConsoleMenu;

public class TaskService {

    public Task findTask(Project project, int taskId) {
        for (Task task : project.getTasks()) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public boolean addTask(Project project, String taskName, Task.Status status) {
        for (Task task : project.getTasks()) {
            if (task.getName().equalsIgnoreCase(taskName.trim())) {
                return false;
            }
        }
        project.addTask(new Task(taskName.trim(), status));
        return true;
    }

    public boolean updateTaskStatus(Project project, int taskId, Task.Status status) {
        Task task = findTask(project, taskId);
        if (task == null) {
            return false;
        }
        task.setStatus(status);
        return true;
    }

    public boolean removeTask(Project project, int taskId) {
        return project.removeTask(taskId);
    }

    public boolean assignTask(Project project, int taskId, User user) {
        Task task = findTask(project, taskId);
        if (task == null) {
            return false;
        }
        task.setAssignedTo(user);
        return true;
    }

    public void displayTasks(Project project) {
        Task[] tasks = project.getTasks();

        if (tasks.length == 0) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println(ConsoleMenu.LINE);
        System.out.printf("%-4s | %-20s | %-11s | %s%n", "ID", "TASK NAME", "STATUS", "ASSIGNED TO");
        System.out.println(ConsoleMenu.LINE);

        for (Task task : tasks) {
            String assignee = task.getAssignedTo() == null
                    ? "Unassigned"
                    : task.getAssignedTo().getName();

            System.out.printf(
                    "%-4s | %-20s | %-11s | %s%n",
                    task.getDisplayId(), task.getName(), task.getStatus(), assignee
            );
        }
        System.out.println(ConsoleMenu.LINE);
    }
}
