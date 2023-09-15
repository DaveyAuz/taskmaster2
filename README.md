# taskmaster2
# TaskMaster Android App - Lab 31: Espresso Testing and Polishing

Today, I expanded the testing suite of the TaskMaster Android app by integrating more Espresso UI tests. Additionally, any unfinished or polish-required tasks from the previous labs were addressed. Below is the detailed summary:

## Project Structure

Here's an overview of the project's directory structure:

### Activities

- `AddTasksActivity.java`: Adds new tasks to the app.
- `AllTasksActivity.java`: Displays all tasks.
- `SettingsActivity.java`: Manages user settings.
- `TaskDetailActivity.java`: Displays detailed information about a specific task.
- `MainActivity.java`: Main activity of the app, serves as the homepage.

### Adapter
- `TaskListRecyclerViewAdapter.java`: Manages the RecyclerView for displaying Task data.

### DAO
- `TaskDao.java`: Data Access Object interface for database operations.

### Database
- `TaskMasterDatabase.java`: Room database class for managing Task data.
- `TaskMasterDatabaseConverters.java`: Contains type converters for the Room database.

### Fragment
- `TaskListFragment.java`: Fragment for the task list view.

### Models
- `State.java`: (If it contains specific functionality, describe it)
- `Task.java`: Data model for tasks.

### Resources

#### Drawable
- `ic_launcher_background.xml`
- `ic_launcher_foreground.xml`
- `taskmasterbkgpng.png`: Background image used in the app.

#### Font
- `marvel_bold.xml`: Font resource for bold text.
- `oswald_medium.xml`: Font resource for medium text.

#### Layouts
- `activity_add_tasks.xml`: Layout for "Add Tasks" activity.
- `activity_all_tasks.xml`: Layout for "All Tasks" activity.
- `activity_main.xml`: Layout for main activity.
- `activity_settings.xml`: Layout for "Settings" activity.
- `activity_task_detail.xml`: Layout for "Task Detail" activity.
- `fragment_task_list.xml`: Layout for the task list fragment.

### Espresso Tests
- `MainActivityEspressoTest.java`: Contains the Espresso tests for the main activity.

## Feature Tasks

### Espresso Testing

Added more Espresso UI tests. Here are the core ones:

1. Assert that important UI elements are displayed on the page.
2. Tap on a task, and assert that the resulting activity displays the name of that task.
3. Edit the user's username and assert that the updated username displays correctly on the homepage.

### Polish

Completed, fixed, and polished feature tasks from previous labs.
