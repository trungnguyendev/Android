package dev.trung.recyclerview.models;

/**
 * Created by trungnv on 7/13/2016.
 */

public class User {
    private String name;
    private String description;

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
