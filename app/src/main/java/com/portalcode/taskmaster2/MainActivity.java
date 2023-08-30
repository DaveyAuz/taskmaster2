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
import com.portalcode.taskmaster2.activities.SettingsActivity;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String TASK_DETAIL_TITLE_TAG = "TASK DETAIL TITLE";

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super and setContentView needs to remain at the top
        // setContentView creates all of your UI elements.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setupButton(R.id.addTasksButtonMainActivity, AddTasksActivity.class);
        setupButton(R.id.allTasksButtonMainActivity, AllTasksActivity.class);
        setupImageButton(R.id.imageViewSettingsIconMainActivity, SettingsActivity.class);
        setupTaskButton(R.id.textViewTaskOneMainActivity, "Finish Java Assignment");
        setupTaskButton(R.id.textViewTaskTwoMainActivity, "Walk Dog!");
        setupTaskButton(R.id.textViewTaskThreeMainActivity, "Clean Dishes!");
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    // Add the new methods for the added features here

}
