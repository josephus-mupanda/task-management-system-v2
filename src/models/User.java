package models;

public  abstract class User {

    private int id;
    private String name;
    private String email;
    private String role;

    private static int nextId = 1;

    public User(String name, String email, String role){
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
