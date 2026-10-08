package services;

import models.Project;
import models.Task;

public class ReportService {
    private Project[] projects;

    public ReportService(Project[] projects) {
        this.projects = projects;
    }

    public void displayProjectReport() {

        System.out.println("\n==============================================");
        System.out.println("           PROJECT STATUS REPORT");
        System.out.println("==============================================");

        System.out.printf(
                "%-5s %-20s %-7s %-10s %-12s%n",
                "ID",
                "PROJECT NAME",
                "TASKS",
                "COMPLETED",
                "PROGRESS"
        );

        System.out.println("----------------------------------------------");

        double totalCompletion = 0;
        int projectCount = 0;

        for (Project project : projects) {

            if (project == null) {
                continue;
            }

            int totalTasks = 0;
            int completedTasks = 0;

            for (Task task : project.getTasks()) {

                if (task != null) {

                    totalTasks++;

                    if (task.isCompleted()) {
                        completedTasks++;
                    }
                }
            }

            double percentage =
                    project.getCompletionPercentage();

            System.out.printf(
                    "%-5d %-20s %-7d %-10d %.2f%%%n",
                    project.getId(),
                    project.getName(),
                    totalTasks,
                    completedTasks,
                    percentage
            );

            totalCompletion += percentage;
            projectCount++;
        }

        double average = projectCount == 0
                ? 0
                : totalCompletion / projectCount;

        System.out.println("----------------------------------------------");

        System.out.printf(
                "AVERAGE COMPLETION: %.2f%%%n",
                average
        );
    }
}
