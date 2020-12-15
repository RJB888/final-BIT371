package com.hfad.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewTaskDialog.NewTaskDialogListener {
    ArrayList<ToDo> tasksList;
    NewTaskDialog newTaskDialog;
    private RecyclerView taskListing;
    private DBHelper dbHelper;
    private ToDoItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.taskRecycler);
        newTaskDialog = new NewTaskDialog();
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null, 1);

//        tasksList = ToDo.createToDoList(5);
        tasksList = dbHelper.getTaskList();
        adapter = new ToDoItemAdapter(tasksList, dbHelper);
        rvTasks.setAdapter(adapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

    }

    public void showDialog(View view){
        newTaskDialog.show(this.getSupportFragmentManager(), "New Task");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void storeTask(String text, String date) {
        Log.i("INFO", text + " " + date);
        //add task to db.
        int taskId = dbHelper.insertNewTask(text, date);
        //update arraylist
        adapter.toDoList.add(new ToDo(text, date, 0, taskId));
        //update recyclerview
        adapter.notifyItemInserted(adapter.toDoList.size());
    }

}