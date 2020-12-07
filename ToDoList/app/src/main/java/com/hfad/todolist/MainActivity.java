package com.hfad.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ToDo> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.taskRecycler);

        tasksList = ToDo.createToDoList(50);
        Log.i("INFO", tasksList.get(0).getTask().toString());
        ToDoItemAdapter adapter = new ToDoItemAdapter(tasksList);
        rvTasks.setAdapter(adapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
    }
}