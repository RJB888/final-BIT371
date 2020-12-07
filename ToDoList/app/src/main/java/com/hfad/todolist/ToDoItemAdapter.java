package com.hfad.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoItemAdapter extends RecyclerView.Adapter<ToDoItemAdapter.ToDoItem> {
    private List<ToDo> toDoList;

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

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public ToDoItemAdapter(List<ToDo> tasks) {toDoList = tasks;}

    public class ToDoItem extends RecyclerView.ViewHolder {

        public CheckBox toDoItem;

        public ToDoItem(@NonNull View itemView) {
            super(itemView);
            toDoItem = itemView.findViewById(R.id.toDoItem);
        }
    }

}
