# taskmaster2

# TaskMaster Android App - Lab 29: Room Database Integration

In this lab, I continued enhancing the TaskMaster Android app by implementing Room, a local database, to store Task data and modifying the app to interact with the database. Here are the details of what I accomplished:

## Project Structure

Here's an overview of the project's directory structure:

### Activities

- `AddTasksActivity.java`: Responsible for adding new tasks to the app.
- `AllTasksActivity.java`: Displays all tasks in the app.
- `SettingsActivity.java`: Manages user settings.
- `TaskDetailActivity.java`: Shows detailed information about a specific task.
- `MainActivity.java`: The main activity of the app, serving as the homepage.

### Adapter

- `TaskListRecyclerViewAdapter.java`: Manages the RecyclerView for displaying Task data.

### DAO

- `TaskDao.java`: Data Access Object interface for defining database operations.

### Database

- `TaskMasterDatabase.java`: Room database class for managing Task data.
- `TaskMasterDatabaseConverters.java`: Contains type converters for Room database.

### Fragment

- `TaskListFragment.java`: Represents a fragment for the task list view.

### Models

- `MainActivity.java`: The main activity of the app.

### Resources

#### Drawable

- `ic_launcher_background.xml`
- `ic_launcher_foreground.xml`
- `taskmasterbkgpng.png`: Background image used in the app.

#### Font

- `marvel_bold.xml`: Font resource for bold text.
- `oswald_medium.xml`: Font resource for medium text.

### Layouts

- `activity_add_tasks.xml`: XML layout file for the "Add Tasks" activity.
- `activity_all_tasks.xml`: XML layout file for the "All Tasks" activity.
- `activity_main.xml`: XML layout file for the main activity (homepage).
- `activity_settings.xml`: XML layout file for the "Settings" activity.
- `activity_task_detail.xml`: XML layout file for the "Task Detail" activity.
- `fragment_task_list.xml`: XML layout file for the task list fragment.

Please note that the project structure includes new DAO, Database, and Converters related files for Room integration.

## Feature Tasks

### Task Model and Room

- Integrated Room database into the application.
- Modified the `Task` class to be an Entity in the Room database.

### Add Task Form

- Updated the Add Task form to save the entered data as a Task in the local database.

### Homepage Refactoring

- Refactored the homepage's RecyclerView to display all Task entities from the local database.

### Detail Page Enhancement

- Ensured that the description and status of a tapped task are also displayed on the detail page, in addition to the title.

## Implementation Steps

To achieve these tasks, I followed the Android documentation to set up Room and performed the following steps:

- Created a `TaskDao` interface to define database operations.
- Developed the `TaskMasterDatabase` class as the Room database and included necessary entities and converters.
- Modified the `Task` class to be a Room Entity.
- Updated the Add Task form to save data to the local database.
- Refactored the homepage's RecyclerView to retrieve Task entities from the database.
- Enhanced the detail page to display Task details.

## Documentation

- Updated the daily change log in the README with today’s modifications.

## Testing

- I haven't gotten around to using Espresso testing yet, but that is the next step in my application development.

## Stretch Goals (Optional)

While not part of the core tasks, I considered the following stretch goals for further app improvement:

- **Dynamic Task Display**: Allowing the user to specify on their settings page how many tasks should be shown on the homepage. This feature would dynamically display the requested number of tasks in the RecyclerView.

- **Task Sorting**: Allowing the user to specify on their settings page how the tasks should be sorted (by title, status, or creation time).

## Submission Instructions

- Continued to work in the "taskmaster" repository.
- Worked on a non-master branch and committed changes appropriately.
- Updated the README with today's progress.
- Created a pull request to the master branch with the lab work.
- Submitted the pull request link on Canvas and added a comment indicating the time spent on this assignment.


