package com.portalcode.taskmaster2.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.portalcode.taskmaster2.models.Task; // Make sure to adjust the package name if needed

import java.util.List;

@Dao                //This is like a Spring JPA repository, except it implements nothing for you
public interface TaskDao {
    @Insert
    void insertTask(Task task);

    @Query("SELECT * FROM task")
    List<Task> findAll();
}






