package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Items")
public class Items {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "name", nullable = false)
    private String title;

    @Column(name = "short_description")
    private String description;

    @Column(name = "task_status", nullable = false)
    private int status;

    // Constructors
    public Items() {}

    public Items(String id, String title, String description, int status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
