package com.portalcode.taskmaster2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.portalcode.taskmaster2.dao.TaskDao;
import com.portalcode.taskmaster2.models.Task;

@Database(entities = {Task.class}, version = 1)
@TypeConverters({TaskMasterDatabaseConverters.class})
public abstract class TaskMasterDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}