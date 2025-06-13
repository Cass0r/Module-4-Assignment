package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Items {

    @Id
    @Column(name = "ID")
    private String ID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_description")
    private String short_description;

    @Column(name = "task_status", nullable = false)
    private boolean task_status;

    // Constructors, getters, setters, toString...

    public Items() {} // Required by Hibernate

    public Items(String ID, String name, String short_description, boolean task_status) {
        this.ID = ID;
        this.name = name;
        this.short_description = short_description;
        this.task_status = task_status;
    }
    //Getters
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getShort_description() {
        return short_description;
    }

    public boolean isTask_status() {
        return task_status;
    }

    //Setters
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public void setTask_status(boolean task_status) {
        this.task_status = task_status;
    }

    //Display Items Info
    public String toString() {
        return "\n=================Item Info=================" +
                "\nItem ID: " + ID +
                "\nItem Name: " + name +
                "\nItem Description: " + short_description +
                "\nTask Status: " + task_status +
                "\n==========================================";
    }
}
