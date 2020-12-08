package com.hfad.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewTaskDialog.NewTaskDialogListener {
    ArrayList<ToDo> tasksList;
    NewTaskDialog newTaskDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.taskRecycler);
        newTaskDialog = new NewTaskDialog();

        tasksList = ToDo.createToDoList(5);
        Log.i("INFO", tasksList.get(0).getTask().toString());
        ToDoItemAdapter adapter = new ToDoItemAdapter(tasksList);
        rvTasks.setAdapter(adapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

//        Button newTaskBtn = (Button) findViewById(R.id.newTaskButton).setOnClickListener();
    }

    public void showDialog(View view){
        newTaskDialog.show(this.getSupportFragmentManager(), "New Task");
    }


    @Override
    public void storeTask(String text, String date) {
        Log.i("INFO", text + " " + date);
    }
}