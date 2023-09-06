package com.portalcode.taskmaster2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

public enum State {
    NEW("New"),
    ASSIGNED("Assigned"),
    IN_PROGRESS("In Progress"),
    COMPLETE("Complete");

    private final String taskText;

    State(String taskText) {
        this.taskText = taskText;
    }

    public String getTaskText() {
        return taskText;
    }

    public static State fromString(String possibleTaskText) {
        for (State state : State.values()) {
            if (state.taskText.equals(possibleTaskText)) {
                return state; // Corrected 'task' to 'state'
            }
        }
        return null;
    }

    @NonNull
    @Override
    public String toString() {
        if (taskText == null) {
            return "";
        }
        return taskText;
    }
}