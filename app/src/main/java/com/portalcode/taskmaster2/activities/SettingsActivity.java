package com.portalcode.taskmaster2.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.portalcode.taskmaster2.R;

public class SettingsActivity extends AppCompatActivity {

    // create a string for logging
    public String TAG = "SettingsActivity";
    public static final String USER_NAME_TAG = "userNickname";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // need to set preferences outside of the onClick() function because of the "this" context.
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUserNickname();
        saveUserNickname();
    }

    public void setUserNickname() {
        String userNickname = preferences.getString(USER_NAME_TAG, "");
        if (!userNickname.isEmpty()) {
            EditText userNameEditText = findViewById(R.id.editTextUsernameSettingsActivity);
            userNameEditText.setText(userNickname);
        }
    }

    public void saveUserNickname() {
        Button buttonToSaveUsername = findViewById(R.id.buttonSaveUsernameSettingsActivity);
        buttonToSaveUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("saved!");
                Log.e(TAG, "Logging");

                // save username from edit text box, which gets passed to MainActivity
                SharedPreferences.Editor preferencesEditor = preferences.edit();
                EditText userNameEditText = findViewById(R.id.editTextUsernameSettingsActivity);
                String userNicknameString = userNameEditText.getText().toString();
                preferencesEditor.putString(USER_NAME_TAG, userNicknameString);
                preferencesEditor.apply();
                ((TextView) findViewById(R.id.textViewSavedSettingsActivity)).setText(getString(R.string.save));
            }
        });
    }
}
