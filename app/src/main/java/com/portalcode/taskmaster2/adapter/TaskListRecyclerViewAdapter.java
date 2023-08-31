package com.portalcode.taskmaster2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.portalcode.taskmaster2.R;
import com.portalcode.taskmaster2.activities.TaskDetailActivity;
import com.portalcode.taskmaster2.MainActivity;
import com.portalcode.taskmaster2.models.Task;

import java.util.List;

public class TaskListRecyclerViewAdapter extends RecyclerView.Adapter<TaskListRecyclerViewAdapter.TaskListViewHolder> {

    private List<Task> taskArrayList;
    private Context callingActivity;

    // Constructor
    public TaskListRecyclerViewAdapter(List<Task> taskArrayList, Context callingActivity) {
        this.taskArrayList = taskArrayList;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task_list, parent, false);
        return new TaskListViewHolder(taskFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TextView taskFragmentTextView = holder.itemView.findViewById(R.id.textViewTaskFragmentTaskListFragment);
        Task task = taskArrayList.get(position);
        taskFragmentTextView.setText(task.getName());

        // Set onClick listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task clickedTask = taskArrayList.get(position); // Get the clicked task
                String taskTitle = clickedTask.getName();
                String taskBody = clickedTask.getBody();
                String taskState = clickedTask.getState().toString();

                Intent goToTaskDetailActivity = new Intent(callingActivity, TaskDetailActivity.class);
                goToTaskDetailActivity.putExtra(MainActivity.TASK_TITLE_TAG, taskTitle);
                goToTaskDetailActivity.putExtra(MainActivity.TASK_BODY_TAG, taskBody);
                goToTaskDetailActivity.putExtra(MainActivity.TASK_STATE_TAG, taskState);
                callingActivity.startActivity(goToTaskDetailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public static class TaskListViewHolder extends RecyclerView.ViewHolder {
        public TaskListViewHolder(View fragmentItemView) {
            super(fragmentItemView);
        }
    }
}


