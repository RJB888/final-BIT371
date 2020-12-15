package com.hfad.todolist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoItemAdapter extends RecyclerView.Adapter<ToDoItemAdapter.ToDoItem> {
    public List<ToDo> toDoList;
    private DBHelper dbHelper;

    @NonNull
    @Override
    public ToDoItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View toDoView = inflater.inflate(R.layout.to_do_item, parent, false);
        ToDoItem toDoItemView = new ToDoItem(toDoView);
        return toDoItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoItem holder, int position) {
        ToDo item = toDoList.get(position);
        holder.toDoItem.setText(item.getTask());
        holder.toDoItem.setChecked(item.getComplete());

        //set listener to listen for checkbox click
        holder.toDoItem.setOnCheckedChangeListener(
                (v, checked) -> {
                    ToDo task = toDoList.get(holder.getAdapterPosition());
                    dbHelper.updateDone(task.getId(), checked);
                }
        );
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public ToDoItemAdapter(List<ToDo> tasks, DBHelper helper) {
        toDoList = tasks;
        dbHelper = helper;

    }

    public class ToDoItem extends RecyclerView.ViewHolder {

        public CheckBox toDoItem;

        public ToDoItem(@NonNull View itemView) {
            super(itemView);
            toDoItem = itemView.findViewById(R.id.toDoItem);
        }
    }

}
