package com.example.jo.tasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "TASKDetails";

    //You will declare all your table names here.
    private static final String TABLE_TASKS = "tasks";

    // TASKs Table Columns names
    private static final String KEY_TASK_ID = "id";
    private static final String KEY_TASK_NAME = "TASKName";
    private static final String KEY_TASK_EMAIL = "duration";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TASKS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_TASKS + "("
                + KEY_TASK_ID + " INTEGER (10) PRIMARY KEY,"
                + KEY_TASK_NAME + " TEXT, "
                + KEY_TASK_EMAIL + " TEXT" + ")";

        //Create table query executed in sqlite
        db.execSQL(CREATE_TASKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        // Create tables again
        onCreate(db);
    }
    public void Add_task(Task task){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_TASK_ID,task.getId());
        values.put(KEY_TASK_NAME,task.getName());
        values.put(KEY_TASK_EMAIL,task.getDuration());
        db.insert(TABLE_TASKS,null,values);
        db.close();
    }
}
