package com.example.jo.databasecrud;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView task;
    EditText name,id,duration;
    Button save,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public void init(){
        task=(TextView)findViewById(R.id.task);
        name=(EditText)findViewById(R.id.name);
        id =(EditText)findViewById(R.id.id);
        duration=(EditText)findViewById(R.id.duration);
        save=(Button)findViewById(R.id.save);
        show=(Button)findViewById(R.id.show);
    }

    public void save(View view) {
        int task_id=Integer.valueOf(id.getText().toString());
        DataBaseHelper dp=new DataBaseHelper(MainActivity.this);
        task taskObject=new task(name.getText().toString(),Integer.valueOf(id.getText().toString()),Integer.valueOf(duration.getText().toString()));
        dp.AddTask(taskObject);
        Toast.makeText(MainActivity.this,"Your task is saved successfully",Toast.LENGTH_LONG).show();

    }

    public void show(View view) {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }

    public void update(View view) {
        Toast.makeText(MainActivity.this, "your data is saved successfully", Toast.LENGTH_SHORT).show();
    }
}
