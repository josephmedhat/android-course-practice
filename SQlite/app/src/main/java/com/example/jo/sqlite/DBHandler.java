package com.example.jo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    //Database version.

    //Note: Increase the database version every-time you make changes to your table structure.
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "studentDetails";

    //You will declare all your table names here.
    private static final String TABLE_STUDENTS = "students";

    // Students Table Columns names
    private static final String KEY_STUDENT_ID = "studentID";
    private static final String KEY_STUDENT_NAME = "studentName";
    private static final String KEY_STUDENT_EMAIL = "studentEmail";

    //Here context passed will be of application and not activity.
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Query to create table
        String CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_STUDENTS + "("
                + KEY_STUDENT_ID + " INTEGER (10) PRIMARY KEY,"
                + KEY_STUDENT_NAME + " TEXT, "
                + KEY_STUDENT_EMAIL + " TEXT" + ")";
        //Create table query executed in sqlite
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        // Create tables again
        onCreate(db);
    }


    public void addStudent(StudentModel student) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Content values use KEY-VALUE pair concept
        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_ID, student.getStudentID());
        values.put(KEY_STUDENT_NAME, student.getStudentName());
        values.put(KEY_STUDENT_EMAIL, student.getStudentEmail());
        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }

    public StudentModel getStudent(int studentID) {

        SQLiteDatabase db = this.getReadableDatabase();

        //You can browse to the query method to know more about the arguments.
        Cursor cursor = db.query(TABLE_STUDENTS,

                new String[] { KEY_STUDENT_ID, KEY_STUDENT_NAME, KEY_STUDENT_EMAIL },

                KEY_STUDENT_ID + "=?",

                new String[] { String.valueOf(studentID)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        StudentModel student = new StudentModel(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2));

        //Return Student
        return student;
    }

    public void updateStudent(StudentModel student){
        SQLiteDatabase db = this.getWritableDatabase();
        //Content values use KEY-VALUE pair concept
        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_ID, student.getStudentID());
        values.put(KEY_STUDENT_NAME, student.getStudentName());
        values.put(KEY_STUDENT_EMAIL, student.getStudentEmail());
        db.update(TABLE_STUDENTS, values,KEY_STUDENT_ID+" = ?",new String[]{String.valueOf(student.getStudentID())});
        db.close();
    }

    public void deleteStudent(StudentModel student){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENTS,KEY_STUDENT_ID+" = ?",new String[]{String.valueOf(student.getStudentID())});
        db.close();

    }

    public List<StudentModel> getAllStudents() {
        ArrayList<StudentModel> studentList = new ArrayList<StudentModel>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentModel student = new StudentModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2));

                studentList.add(student);
            } while (cursor.moveToNext());
        }
        // return student list
        return studentList;
    }

}
