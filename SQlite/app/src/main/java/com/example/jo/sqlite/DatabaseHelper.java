package com.example.jo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Database version.
    //Note: Increase the database version every-time you make changes to your table structure.
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "Tasks";

    //You will declare all your table names here.
    private static final String Table_name = "tasks";

    // Students Table Columns names
    private static final String id = "task_id";
    private static final String title = "title";
    private static final String duration = "duration";

    //Here context passed will be of application and not activity.
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Query to create table
        String createQuery = "CREATE TABLE IF NOT EXISTS "
                + Table_name + "("
                + id + " INTEGER (10) PRIMARY KEY, "
                + title + " TEXT, "
                + duration + " TEXT" + ")";

        //Create table query executed in sqlite
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);

        // Create tables again
        onCreate(db);
    }

}
