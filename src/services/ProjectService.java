package services;

import models.HardwareProject;
import models.Project;
import models.SoftwareProject;

public class ProjectService {
    private Project[] projects;

    public ProjectService(Project[] projects) {
        this.projects = projects;
    }

    public Project findProject(int projectId) {

        for (Project project : projects) {
            if (project != null && project.getId() == projectId) {
                return project;
            }
        }

        return null;
    }

    public void displayProjects() {

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

    public void filterByType(String type) {

        for (Project project : projects) {

            if (project == null) {
                continue;
            }

            boolean matches =
                    type.equalsIgnoreCase("Software")
                            && project instanceof SoftwareProject
                            ||
                            type.equalsIgnoreCase("Hardware")
                                    && project instanceof HardwareProject;

            if (matches) {
                System.out.printf(
                        "%d | %s | %s | Team: %d | Budget: $%.2f%n",
                        project.getId(),
                        project.getName(),
                        type,
                        project.getTeamSize(),
                        project.getBudget()
                );
            }
        }
    }
}
