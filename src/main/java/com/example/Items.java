package com.example;

import javax.persistence.*;


@Entity
@Table(name = "Items") // <-- Make sure this matches your table name exactly (case-sensitive)
public class Items {

    @Id
    private String id;

    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "task_status")
    private int taskStatus;

    public Items(String id,String name, String shortDescription, int taskStatus){
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.taskStatus = taskStatus;
    }
    // Hibernate requires this
    public Items() {

    }

    // Getters and setters (or public fields if you're keeping it simple)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public int getTaskStatus() { return taskStatus; }
    public void setTaskStatus(int taskStatus) { this.taskStatus = taskStatus; }
}
