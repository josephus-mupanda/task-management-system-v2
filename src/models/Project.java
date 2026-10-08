package models;

public abstract class Project {
    private int id;
    private String name;
    private String description;
    private double budget;
    private int teamSize;
    private Task[] tasks;

    public Project(int id, String name, String description, double budget, int teamSize)
    {
     this.id = id;
     this.name =  name;
     this.description =  description;
     this.budget = budget;
     this.teamSize =  teamSize;
     this.tasks = new Task[10];
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

    public void addTask(Task task){
        for( int i = 0; i<tasks.length; i++){
            if(tasks[i] == null){
                tasks[i] = task;
                return;
            }
        }
    }
    public Task[] getTasks(){
        return tasks;
    }

    public double getCompletionPercentage(){
        int totalTasks = 0;
        int completedTasks = 0;

        for(Task task: tasks){
            if( task != null){
                totalTasks++;
                if(task.isCompleted()){
                    completedTasks++;
                }
            }
        }
        if(totalTasks ==0){
            return 0.0;
        }
        return (double) completedTasks /totalTasks *100;
    }
}
