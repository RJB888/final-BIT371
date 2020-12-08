package com.hfad.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ToDoTasks";
    public static final String TABLE_NAME = "Tasks";
    public static final String CHECKED_COL = "done";
    public static final String TASK_COL = "text";
    public static final String DATE_COL = "date_due";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE table_name(_id INTEGER PRIMARY KEY AUTOINCREMENT,  col1 TEXT, col2 INTEGER, col3 TEXT)
        db.execSQL(
                "CREATE TABLE " + DBHelper.TABLE_NAME + "(" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DBHelper.CHECKED_COL + " INTEGER," +
                        DBHelper.TASK_COL + " TEXT," +
                        DBHelper.DATE_COL + " TEXT" +
        ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
