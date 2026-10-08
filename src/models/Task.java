package models;

import interfaces.Completable;

public class Task  implements Completable {

    private static int nextId = 1;

    private int id;
    private String name;
    private String status;

    public Task(String name, String status) {
        this.id = nextId++;
        this.name = name;
        this.status = status;
    }

    @Override
    public boolean isCompleted() {
        return status.equalsIgnoreCase("Completed");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

