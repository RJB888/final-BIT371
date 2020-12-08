package com.hfad.todolist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;

public class TaskCursorAdapter extends CursorAdapter {
    public TaskCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.to_do_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CheckBox task = view.findViewById(R.id.toDoItem);
        int checkedVal = cursor.getInt(cursor.getColumnIndex(DBHelper.CHECKED_COL));
        String text = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_COL));
        String date = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COL));
        task.setChecked(checkedVal == 1 ? true : false);
        task.setText(String.format(task + "\nDue on: " + date));
    }
}
