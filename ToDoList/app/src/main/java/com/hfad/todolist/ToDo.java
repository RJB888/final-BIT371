package com.hfad.todolist;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class ToDo {
    private String taskText;
    private String dateDue;
    private boolean isComplete;
    private int id;


    public ToDo(String task, String date, int done, int item_id){
        id = item_id;
        taskText = String.format(task + "\nDue On: %s", date);
        isComplete = done == 1;
        dateDue = date;

    }

    public int getId(){
        return id;
    }

    public String getTask() {
        return taskText;
    }

    public boolean getComplete() {
        return isComplete;
    }
    public void setComplete(boolean done){
        isComplete = done;
    }

    //For testing purposes create array of sample tasks
    public static ArrayList<ToDo> createToDoList(int numTasks){
        ArrayList<ToDo> toDoSampleList = new ArrayList<>();
        ToDo placeholder;
        for (int i = 0; i < numTasks; i++){
            placeholder = new ToDo("Finish the final.", "12.15.2020", 1, 6);
            toDoSampleList.add(placeholder);
        }
        return toDoSampleList;
    }

}
