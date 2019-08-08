package com.example.jo.databasecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText Id;
    TextView value;
    Button show;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        db=new DataBaseHelper(Main2Activity.this);
    }
    public void init(){
        Id=(EditText)findViewById(R.id.editText2);
        value=(TextView)findViewById(R.id.textView);
        show=(Button)findViewById(R.id.button);
    }

    public void getvalue(View view) {
        task tasks=db.getTask(Integer.valueOf(Id.getText().toString()));
        Log.d("show",tasks.getName());
        value.setText(tasks.getName());
    }
}
