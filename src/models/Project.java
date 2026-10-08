package models;

public abstract class Project {
    private int id;
    private String name;
    private String description;
    private double budget;
    private int teamSize;

    public Project(int id, String name, String description, double budget, int teamSize)
    {
     this.id = id;
     this.name =  name;
     this.description =  description;
     this.budget = budget;
     this.teamSize =  teamSize;
    }

    public abstract String getProjectDetails();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getBudget() {
        return budget;
    }
    public int getTeamSize(){
        return teamSize;
    }
}
