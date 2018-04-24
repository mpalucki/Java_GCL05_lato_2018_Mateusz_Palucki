package com.company;

public class TaskExecute {

    Task task;
    String taskName;

    public TaskExecute(Task task, String taskName)
    {
        this.taskName = taskName;
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public String getTaskName() {
        return taskName;
    }
}
