package com.portalcode.taskmaster2;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDisplayUIElements() {
        // Assert that important UI elements are displayed on the page
        Espresso.onView(ViewMatchers.withId(R.id.textViewUsernameMainActivity))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.addTasksButtonMainActivity))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.allTasksButtonMainActivity))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.imageButtonSettingsIconMainActivity))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Add more assertions for other UI elements as needed
    }

    @Test
    public void testTaskNavigation() {
        // Tap on a task and assert that the resulting activity displays the name of that task
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewTaskListMainActivity))
                .perform(ViewActions.click()); // Replace with the appropriate RecyclerView item

        Espresso.onView(ViewMatchers.withText("Task Title")) // Replace with the expected task title
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Add more assertions related to the task navigation and detail page
    }

    @Test
    public void testEditUsername() {
        // Edit the user's username and assert that it displays the correct updated username
        Espresso.onView(ViewMatchers.withId(R.id.imageButtonSettingsIconMainActivity))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.editTextUsernameSettingsActivity))
                .perform(ViewActions.typeText("New Username"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.buttonSaveUsernameSettingsActivity))
                .perform(ViewActions.click()); // Updated ID to match your layout

        Espresso.onView(ViewMatchers.withId(R.id.textViewUsernameMainActivity))
                .check(ViewAssertions.matches(ViewMatchers.withText("Hello, New Username!"))); // Replace with the expected username
    }

    @Test
    public void setNicknameTest() {
        // Your existing setNicknameTest code goes here

        // For example:
        // Espresso.onView(ViewMatchers.withId(R.id.imageViewSettingsIconMainActivity))
        //         .perform(ViewActions.click());

        // Add the rest of your setNicknameTest code here
    }
}
