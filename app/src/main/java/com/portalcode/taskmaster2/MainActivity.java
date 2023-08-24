package com.portalcode.taskmaster2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super and setContentView needs to remain at the top
        // setContentView creates all of your UI elements.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // step 1: Get UI components
        Button buttonToAddTaskPage = (Button) findViewById(R.id.addTaskButtonMainActivity);
        Button buttonToAllTasksPage = (Button) findViewById(R.id.allTasksButtonMainActivity);

// Set onClickListener to navigate to addTaskPage
        buttonToAddTaskPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "Logging");

                Intent goToAddTaskPage = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(goToAddTaskPage);
            }
        });

        // Set onClickListener to navigate to allTaskPage
        buttonToAllTaskPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "Logging");

                Intent goToAllTaskPage = new Intent(MainActivity.this, AllTasksActivity.class);
                startActivity(goToAllTaskPage);
            }
        });
    }
}