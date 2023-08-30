package com.portalcode.taskmaster2.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.portalcode.taskmaster2.R;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String TAG = "TaskDetailActivity";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String taskTitle = preferences.getString("TASK DETAIL TITLE", "Empty");
        TextView taskTitleTextView = findViewById(R.id.textViewTaskTitleDetailsActivity);
        taskTitleTextView.setText(getString(R.string.task_title, taskTitle));
    }
}
