# taskmaster2
# TaskMaster Android App - Lab 29

In this lab, I continued to enhance the TaskMaster Android app by implementing a RecyclerView to display a list of Task data with the addition of new classes and functionality. Here are the details of what I accomplished:

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

### Fragment

- `TaskListFragment.java`: Represents a fragment for the task list view.

### Models

- `State.java`: Defines the possible states of a Task.
- `Task.java`: Represents a Task with title, body, and state properties.

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

Feel free to update this section with additional resources or directories as needed.

## Feature Tasks

### Task Model

- Created a `Task` class with the following instance variables:
  - Title
  - Body
  - State (one of "new," "assigned," "in progress," or "complete").

### Homepage Refactoring

- Refactored the homepage to utilize a RecyclerView for displaying Task data.
- Populated the RecyclerView with hardcoded Task data.

### Implementation Steps

To achieve these tasks, I took the following steps:

- Created a `ViewAdapter` class, `TaskListRecyclerViewAdapter`, responsible for displaying data from a list of `Task` objects.
- In the `MainActivity`, generated at least three hardcoded `Task` instances and used them to populate the RecyclerView through the `TaskListRecyclerViewAdapter`.
- Enabled the functionality to tap on any Task item within the RecyclerView, which correctly launches the detail page with the corresponding Task title displayed.

## Documentation

- Replaced the homepage screenshot to reflect the updated RecyclerView layout.
- Updated the daily change log in the README with today’s modifications.

## Stretch Goals (Optional)

While not part of the core tasks, I considered the following stretch goals for further app improvement:

- **Styling**: Decided on a color scheme and font families for the app to enhance its visual appeal.

- **Dynamic Task Display**: Considered allowing users to specify the number of tasks to be shown on the homepage via a settings page. This feature would dynamically create and display the requested number of tasks in the RecyclerView.

- **Detailed Task Display**: Planned to send not only the Task title to the detail page but also display the description of that task instead of the Lorem Ipsum text.

## Testing

Although Android UI testing with Espresso is planned for the future, I ensured good unit test coverage for testable code sections in the app.

## Submission Instructions

- Continued to work in the "taskmaster" repository.
- Worked on a non-master branch and committed changes appropriately.
- Updated the README with today's progress, including a screenshot of the updated homepage.
- Created a pull request to the master branch with the lab work.
- Submitted the pull request link on Canvas and added a comment indicating the time spent on this assignment.

---

![TMD2](https://github.com/DaveyAuz/taskmaster2/assets/123343666/5e234d61-9355-44f6-98f5-c8cb1db9a25f)


