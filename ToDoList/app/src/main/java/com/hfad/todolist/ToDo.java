package com.hfad.todolist;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ToDo {
    private String taskText;
    private boolean isComplete;
    private String dateDue;

    public ToDo(String task, boolean complete){
        taskText = task;
        isComplete = complete;
    }

    public String getTask() {
        return taskText;
    }

    public boolean getComplete() {
        return isComplete;
    }

    //For testing purposes create array of sample tasks

    public static ArrayList<ToDo> createToDoList(int numTasks){
        ArrayList<ToDo> toDoSampleList = new ArrayList<>();
        for (int i = 0; i < numTasks; i++){
            toDoSampleList.add(new ToDo(String.format("Task %d. Due on: %s", i + 1, "1.1.11"), false));
        }
        return toDoSampleList;
    }
}
