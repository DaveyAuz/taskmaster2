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

    public static final String TAG = "SettingsActivity";
    public static final String USER_NAME_TAG = "userNickname";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUserNickname();
        saveUserNickname();
    }

    public void setUserNickname() {
        String userNickname = preferences.getString(USER_NAME_TAG, "");
        if (!userNickname.isEmpty()) {
            EditText userNameEditText = findViewById(R.id.editTextUsernameSettings);
            userNameEditText.setText(userNickname);
        }
    }

    public void saveUserNickname() {
        Button buttonToSaveUsername = findViewById(R.id.buttonSaveUsernameSettings);
        buttonToSaveUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "Logging");

                SharedPreferences.Editor preferencesEditor = preferences.edit();
                EditText userNameEditText = findViewById(R.id.editTextUsernameSettings);
                String userNicknameString = userNameEditText.getText().toString();
                preferencesEditor.putString(USER_NAME_TAG, userNicknameString);
                preferencesEditor.apply();

                TextView savedTextView = findViewById(R.id.textViewSavedSettings);
                savedTextView.setText(getString(R.string.saved_settings_activity, userNicknameString));

            }
        });
    }
}
