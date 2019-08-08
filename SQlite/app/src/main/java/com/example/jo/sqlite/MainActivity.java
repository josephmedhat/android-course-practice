package com.example.jo.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHandler db;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv_values);
        db = new DBHandler(this);
       /* StudentModel student=new StudentModel(55,"jo","nadeen@gmail.com");
        db.addStudent(student);*/
        StudentModel student1=new StudentModel(2,"nadeen","nnnadeen@gmail.com");
       // db.addStudent(student1);
        db.updateStudent(student1);
       StudentModel  student= db.getStudent(2);
       tv.setText(student.getStudentName());
        //addDataToDatabase();

        Log.d("test","Running . . .");

        //readDataFromDatabase();
        readDataFromDatabase();
    }

    private void readOne() {
        StudentModel i = db.getStudent(234567);
        String log = "Id: " + i.getStudentID() + " ,Name: " + i.getStudentName() + " ,Email: " + i.getStudentEmail();
        Log.d("MainActivity", log);


    }

    private void readDataFromDatabase() {
        // Reading all studentsSt
        Log.d("MainActivity", "Reading all students..");
        List<StudentModel> students = db.getAllStudents();

        for (StudentModel i : students) {
            String log = "Id: " + i.getStudentID() + " ,Name: " + i.getStudentName() + " ,Email: " + i.getStudentEmail();
            // Writing students to log
            Log.d("MainActivity", log);
        }
    }

    private void addDataToDatabase() {
        // Inserting Students
        Log.d("MainActivity", "Inserting ..");
        db.addStudent(new StudentModel(234567, "Rajat", "rajat@gmail.com"));
        db.addStudent(new StudentModel(955689, "ABC", "abc@gmail.com"));
        db.addStudent(new StudentModel(345129, "XYZ", "xyz@gmail.com"));
    }
}
