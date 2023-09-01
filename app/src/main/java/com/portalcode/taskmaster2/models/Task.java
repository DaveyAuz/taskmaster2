package com.portalcode.taskmaster2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity // Annotation to indicate that this is an entity for Room
public class Task {

    @PrimaryKey(autoGenerate = true) // Annotating a field as the primary key
    private int id;

    private String name;
    private String body;
    private State state;

    public Task(String name, String body, State state) {
        this.name = name;
        this.body = body;
        this.state = state;
    }

    // Getter and setter methods for fields (name, body, state)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}