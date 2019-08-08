package com.example.jo.databasecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int database_version = 1;
    private static final String database_name = "Tasks";
    private static final String table_name = "tasks";
    private static final String name = "Name";
    private static final String id = "ID";
    private static final String duration = "Duration";

    public DataBaseHelper(Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TASKS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + table_name + "("
                + id + " INTEGER (10) PRIMARY KEY,"
                + name + "TEXT ,"
                + duration + "TEXT" + ")";

        db.execSQL(CREATE_TASKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public void AddTask(task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id, task.getId());
        values.put(name, task.getName());
        values.put(duration, task.getDuration());
        db.insert(table_name, null, values);
        db.close();
    }

    public task getTask(int task_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_name, new String[]{name, id, duration}, id + "=?", new String[]{String.valueOf(task_id)}, null, null, null, null);
        Log.d("db","Query Done . . . . ");
        if (cursor != null) {
            cursor.moveToFirst();
        }
        task tasks = new task(
                cursor.getString(0),
                Integer.valueOf(cursor.getString(1)),
                Integer.valueOf(cursor.getString(2))
        );
        return tasks;
    }

    public void updateTask(task tasks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id, tasks.getId());
        values.put(name, tasks.getName());
        values.put(duration, tasks.getDuration());
        db.update(table_name, values, id + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
