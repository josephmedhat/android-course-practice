package com.example.jo.recipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView x;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        x=(TextView)findViewById(R.id.textView);
        String value=getIntent().getStringExtra("value");
        x.setText(value);
    }
}
