package com.portalcode.taskmaster2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room; // Import Room package

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    public static final String TASK_TITLE_TAG = "taskTitle";
    public static final String TASK_BODY_TAG = "Body";
    public static final String TASK_STATE_TAG = "State";
    public static final String TASK_DETAIL_TITLE_TAG = "TASK DETAIL TITLE";

    SharedPreferences preferences;
    //Create and attach the RV Adapter
    TaskListRecyclerViewAdapter taskListRecyclerViewAdapter;
    TaskMasterDatabase taskMasterDatabase;
    List<Task> taskArrayList = null;

    //    private SharedPreferences preferences;
// super and setContentView needs to remain at the top
// setContentView creates all of your UI elements.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize RecyclerView Adapter
        taskListRecyclerViewAdapter = new TaskListRecyclerViewAdapter(taskArrayList, this);

        // Initialize SharedPreferences
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Initialize Room database
        taskMasterDatabase = Room.databaseBuilder(
                getApplicationContext(),
                TaskMasterDatabase.class,
                "task_master_database"
        ).allowMainThreadQueries().build(); // Note: avoid running on main thread in production
        taskArrayList = taskMasterDatabase.taskDao().findAll();

//        Log.d(TAG, "onCreate() got called!");

        addTaskNavigationButton();
        allTasksNavigationButton();
        settingsNavigationButton();
        taskListRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() got called!");
        String userNickname = preferences.getString(SettingsActivity.USER_NAME_TAG, "No nickname");
        TextView usernameTextView = findViewById(R.id.textViewUsernameMainActivity);
        usernameTextView.setText(getString(R.string.nickname_main_activity, userNickname));
    }

    private void setupButton(int buttonId, final Class<?> targetActivityClass) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "Logging");
                Intent intent = new Intent(MainActivity.this, targetActivityClass);
                startActivity(intent);
            }
        });
    }

    private void setupImageButton(int buttonId, final Class<?> targetActivityClass) {
        ImageButton imageButton = findViewById(buttonId);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "Logging");
                Intent intent = new Intent(MainActivity.this, targetActivityClass);
                startActivity(intent);
            }
        });
    }

    private void setupTaskButton(int buttonId, final String taskTitle) {
        TextView taskButton = findViewById(buttonId);
        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "Logging");
                Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
                startActivity(intent);
                SharedPreferences.Editor preferenceEditor = preferences.edit();
                preferenceEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                preferenceEditor.apply();
            }
        });
    }

    public void addTaskNavigationButton() {
        Button addTaskButton = findViewById(R.id.addTasksButtonMainActivity);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Logging");
                // target textview and change what gets printed to that view- don't hardcode values, set values in the string.xml file.

                // use intent to navigate to different pages
                // Intent has two arguments: the context where you're coming from (aka the source Activity), and the place where you're going (the destination Activity)
                Intent intent = new Intent(MainActivity.this, AddTasksActivity.class);
                startActivity(intent);
                // MainActivity.this.startActivity(goToAddTaskPage);
                // Alternate way of using Intent
            }
        });
    }


    public void allTasksNavigationButton() {
        Button buttonToAllTasksPage = findViewById(R.id.allTasksButtonMainActivity);
        buttonToAllTasksPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Logging");
                // target textview and change what gets printed to that view- don't hardcode values, set values in the string.xml file.
                //((TextView)findViewById(R.id.totalTasksTextView)).setText(R.string.submitted);
                // use intent to navigate to different pages
                // Intent has two arguments: the context where you're coming from (aka the source Activity), and the place where you're going (the destination Activity)
                Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
                // Alternate way of using Intent
                // MainActivity.this.startActivity(goToAddTaskPage);
            }
        });
    }

    public void settingsNavigationButton() {
        ImageButton settingsButton = findViewById(R.id.imageButtonSettingsIconMainActivity);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
            }
        });
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(goToSettings);
//            }
//        });
   }

        public void taskListRecyclerView() {
            RecyclerView taskListRecyclerView = findViewById(R.id.recyclerViewTaskListMainActivity);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            taskListRecyclerView.setLayoutManager(layoutManager);
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

            //hand in data items

            taskListRecyclerViewAdapter = new TaskListRecyclerViewAdapter(taskArrayList, this);
            taskListRecyclerView.setAdapter(taskListRecyclerViewAdapter);
        }

    }

