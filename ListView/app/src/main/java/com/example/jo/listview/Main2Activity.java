package com.example.jo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=(TextView)findViewById(R.id.textView);
        String name=getIntent().getStringExtra("name");
        t.setText(name);
    }
}
