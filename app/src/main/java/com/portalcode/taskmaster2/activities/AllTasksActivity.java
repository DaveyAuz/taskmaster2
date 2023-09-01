// AllTasksActivity.java

package com.portalcode.taskmaster2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.portalcode.taskmaster2.R;

public class AllTasksActivity extends AppCompatActivity {

    public String TAG = "AllTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
    }
}
