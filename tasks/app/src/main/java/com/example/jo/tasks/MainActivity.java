package com.example.jo.tasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView task;
    EditText Id;
    EditText name;
    EditText duration;
    Button show;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        task=(TextView)findViewById(R.id.task);
        Id=(EditText)findViewById(R.id.Id);
        name=(EditText)findViewById(R.id.name);
        duration=(EditText)findViewById(R.id.duration);
        show=(Button)findViewById(R.id.show);
        save=(Button)findViewById(R.id.save);
    }

    public void save(View view) {
        DataBaseHelper db=new DataBaseHelper(MainActivity.this);
        int task_id=Integer.valueOf(Id.getText().toString());
        String task_name=name.getText().toString();
        String task_duration=duration.getText().toString();

        Task task =new Task(task_id,task_name,task_duration);
        db.Add_task(task);
        Toast.makeText(MainActivity.this,"Saved !!!",Toast.LENGTH_LONG).show();

    }

    public void show(View view) {
    }
}
