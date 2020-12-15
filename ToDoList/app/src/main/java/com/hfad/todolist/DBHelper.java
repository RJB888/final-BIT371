package com.hfad.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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


//Create
    public int insertNewTask(String text, String date){
        //add new task to db
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.TASK_COL, text);
        contentValues.put(DBHelper.DATE_COL, date);
        contentValues.put(DBHelper.CHECKED_COL, 0);
        return (int) getWritableDatabase().insert(DBHelper.TABLE_NAME, null, contentValues);
    }

//Read
    public ArrayList<ToDo> getTaskList(){
        ArrayList<ToDo> tasks = new ArrayList<>();
        int id;
        String text;
        String date;
        int done;
        SQLiteDatabase readable = getReadableDatabase();
        String[] columns = {"_id", DBHelper.CHECKED_COL, DBHelper.TASK_COL, DBHelper.DATE_COL};
        Cursor cursor = readable.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
            if (cursor.moveToFirst()){
                do {
                    id = cursor.getInt(cursor.getColumnIndex("_id"));
                    text = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_COL));
                    date = cursor.getString(cursor.getColumnIndex(DATE_COL));
                    done = cursor.getInt(cursor.getColumnIndex(CHECKED_COL));
                    tasks.add(new ToDo(text, date, done, id));
                } while (cursor.moveToNext());
            }
        cursor.close();
        return tasks;
    }

//Update
    public boolean updateDone(int taskId, boolean checked){
        //use id to update row from db
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.CHECKED_COL, checked);
        getWritableDatabase().update(DBHelper.TABLE_NAME, cv, "_id=?", new String[]{Integer.toString(taskId)});
        return true;
    }
//Delete - finish this after MVP complete
    public boolean removeTask(){
        //delete task from db
        //delete task from ArrayList
        //update recyclerView
        return true;
    }


}
