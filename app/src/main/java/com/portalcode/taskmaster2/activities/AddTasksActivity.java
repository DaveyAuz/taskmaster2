package com.portalcode.taskmaster2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.portalcode.taskmaster2.R;

public class AddTasksActivity extends AppCompatActivity {

    public String TAG = "AddTasksActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        Button submitButton = findViewById(R.id.addTaskButton)
            @Override
            public void onClick(View view) {
                System.out.println("submitted!");
                Log.d(TAG, "Logging");
            ((TextView) view.findViewById(R.id.textViewSubmit)).setText(R.string.submitted);
        }
    });
}
}