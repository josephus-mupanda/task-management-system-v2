package models;

import interfaces.Completable;

public class Task  implements Completable {

    private int id;
    private String title;
    private String description;
    private boolean completed;

    private User assignedUser;

    public Task(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public void assignTo( User user){
        this.assignedUser = user;
    }
    public  User getAssignedUser(){
        return assignedUser;
    }
    @Override
    public  void complete(){
        completed = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
}

