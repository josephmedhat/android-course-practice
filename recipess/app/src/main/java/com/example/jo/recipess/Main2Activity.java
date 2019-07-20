package com.example.jo.recipess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    EditText email,password;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    public void init (){
        textView=(TextView)findViewById(R.id.textView);
        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        show=(Button)findViewById(R.id.button);
    }

    public void show(View view) {
        Intent i=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i);


    }
}
