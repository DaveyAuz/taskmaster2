package com.portalcode.taskmaster2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.portalcode.taskmaster2.activities.AddTasksActivity;
import com.portalcode.taskmaster2.activities.SettingsActivity;
import com.portalcode.taskmaster2.adapter.TaskListRecyclerViewAdapter;
import com.portalcode.taskmaster2.database.TaskMasterDatabase;
import com.portalcode.taskmaster2.models.Task;
import com.portalcode.taskmaster2.activities.TaskDetailActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String TASK_DETAIL_TITLE_TAG = "TASK DETAIL TITLE";
    public static final String TASK_TITLE_TAG = "TASK_TITLE_TAG";
    public static final String TASK_BODY_TAG = "TASK_BODY_TAG";
    public static final String TASK_STATE_TAG = "TASK_STATE_TAG";

    TaskListRecyclerViewAdapter taskListRecyclerViewAdapter;
    TaskMasterDatabase taskMasterDatabase;
    List<Task> taskArrayList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIElements();
        fetchTasksFromDatabase();
    }

    private void initializeUIElements() {
        setupButton(R.id.addTasksButtonMainActivity, AddTasksActivity.class);
        setupButton(R.id.allTasksButtonMainActivity, SettingsActivity.class); // Should this be SettingsActivity?
        setupImageButton(R.id.imageButtonSettingsIconMainActivity, SettingsActivity.class);
    }

    private void fetchTasksFromDatabase() {
        new AsyncTask<Void, Void, List<Task>>() {
            @Override
            protected List<Task> doInBackground(Void... voids) {
                taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskMasterDatabase.class,
                        "task_master_database"
                ).build();
                return taskMasterDatabase.taskDao().findAll();
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                taskArrayList = tasks;
                setupRecyclerView();
            }
        }.execute();
    }

    private void setupRecyclerView() {
        RecyclerView taskListRecyclerView = findViewById(R.id.recyclerViewTaskListMainActivity);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        taskListRecyclerView.setLayoutManager(layoutManager);

        taskListRecyclerViewAdapter = new TaskListRecyclerViewAdapter(taskArrayList, this);
        taskListRecyclerView.setAdapter(taskListRecyclerViewAdapter);
    }

    private void setupButton(int buttonId, final Class<?> targetActivityClass) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> {
            Log.d(TAG, "Navigating to " + targetActivityClass.getSimpleName());
            Intent intent = new Intent(MainActivity.this, targetActivityClass);
            startActivity(intent);
        });
    }

    private void setupImageButton(int buttonId, final Class<?> targetActivityClass) {
        ImageButton imageButton = findViewById(buttonId);
        imageButton.setOnClickListener(view -> {
            Log.d(TAG, "Navigating to " + targetActivityClass.getSimpleName());
            Intent intent = new Intent(MainActivity.this, targetActivityClass);
            startActivity(intent);
        });
    }
}


//for horizontal layout
// ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);

//        taskArrayList.add((new Task("Assignment", "Finish Java Assignment", State.NEW)));
//        taskArrayList.add((new Task("Dog", "Walk Dog!", State.COMPLETE)));
//        taskArrayList.add((new Task("Dishes", "Clean Dishes!", State.IN_PROGRESS)));
//        taskArrayList.add((new Task("Laundry", "Do Laundry!", State.NEW)));
//        taskArrayList.add((new Task("Groceries", "Buy Groceries!", State.COMPLETE)));
//        taskArrayList.add((new Task("Dinner", "Make Pizza From Scratch!", State.IN_PROGRESS)));
//        taskArrayList.add((new Task("Game", "Level up twice in Elden Ring", State.IN_PROGRESS)));
//        taskArrayList.add((new Task("Exercise", "Swim across cove", State.COMPLETE)));
//        taskArrayList.add((new Task("Clean Truck", "Clean out Truck", State.NEW)));
//        taskArrayList.add((new Task("Read", "Read Clean Code", State.IN_PROGRESS)));
//        taskArrayList.add((new Task("Work", "Finish all work tasks", State.IN_PROGRESS)));