package com.portalcode.taskmaster2;

import androidx.appcompat.app.AppCompatActivity;

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
import com.portalcode.taskmaster2.activities.AllTasksActivity;
import com.portalcode.taskmaster2.activities.TaskDetailActivity;

public class MainActivity extends AppCompatActivity {

    public String TAG = "MainActivity";
    public static String TASK_DETAIL_TITLE_TAG = "TASK DETAIL TITLE";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        addTaskNavigationButton();
        allTasksNavigationButton();
        settingsNavigationButton();
        taskOneButton();
        taskTwoButton();
        taskThreeButton();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String userNickname = preferences.getString(SettingsActivity.USER_NAME_TAG, "No nickname");
        ((TextView)findViewById(R.id.textViewUsernameMainActivity))
                .setText(getString(R.string.nickname_main_activity, userNickname));
    }

    public void addTaskNavigationButton() {
        Button buttonToAddTasksPage = findViewById(R.id.addTasksButtonMainActivity);
        buttonToAddTasksPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.e(TAG, "Logging");

                Intent goToAddTasksPage = new Intent(MainActivity.this, AddTasksActivity.class);
                startActivity(goToAddTasksPage);
            }
        });
    }

    public void allTasksNavigationButton() {
        Button buttonToAllTasksPage = findViewById(R.id.allTasksButtonMainActivity);
        buttonToAllTasksPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.e(TAG, "Logging");

                Intent goToAllTasksPage = new Intent(MainActivity.this, AllTasksActivity.class);
                startActivity(goToAllTasksPage);
            }
        });
    }

    public void settingsNavigationButton() {
        ImageButton imageButtonToSettingsPage = findViewById(R.id.imageViewSettingsIconMainActivity);
        imageButtonToSettingsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.e(TAG, "Logging");

                Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
            }
        });
    }

    public void taskOneButton() {
        TextView taskOneToTaskPage = findViewById(R.id.textViewTaskOneMainActivity);
        taskOneToTaskPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.e(TAG, "Logging");

                Intent goToTaskOneDetails = new Intent(MainActivity.this, TaskDetailActivity.class);
                startActivity(goToTaskOneDetails);
                String taskTitle = "Finish Java Assignment";
                SharedPreferences.Editor preferenceEditor = preferences.edit();
                preferenceEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                preferenceEditor.apply();
            }
        });
    }

    public void taskTwoButton() {
        TextView taskTwoToTaskPage = findViewById(R.id.taskViewTaskTwoMainActivity);
        taskTwoToTaskPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.e(TAG, "Logging");

                Intent goToTaskTwoDetails = new Intent(MainActivity.this, TaskDetailActivity.class);
                startActivity(goToTaskTwoDetails);
                String taskTitle = "Walk Dog!";
                SharedPreferences.Editor preferenceEditor = preferences.edit();
                preferenceEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                preferenceEditor.apply();
            }
        });
    }

    public void taskThreeButton() {
        TextView taskThreeToTaskPage = findViewById(R.id.textViewTaskThreeMainActivity);
        taskThreeToTaskPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.e(TAG, "Logging");

                Intent goToTaskThreeDetails = new Intent(MainActivity.this, TaskDetailActivity.class);
                startActivity(goToTaskThreeDetails);
                String taskTitle = "Clean Dishes!";
                SharedPreferences.Editor preferenceEditor = preferences.edit();
                preferenceEditor.putString(TASK_DETAIL_TITLE_TAG, taskTitle);
                preferenceEditor.apply();
            }
        });
    }

    // Add the new methods for the added features

}
