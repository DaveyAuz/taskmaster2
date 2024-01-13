package com.portalcode.taskmaster2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.portalcode.taskmaster2.MainActivity;
import com.portalcode.taskmaster2.R;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String TAG = "TaskDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String taskTitle = intent.getStringExtra(MainActivity.TASK_DETAIL_TITLE_TAG);
        TextView taskTitleTextView = findViewById(R.id.textViewTaskTitleDetailsActivity);
        taskTitleTextView.setText(getString(R.string.task_title, taskTitle));
    }
}
