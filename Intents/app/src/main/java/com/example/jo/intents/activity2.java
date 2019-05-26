package com.example.jo.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        t1=(TextView)findViewById(R.id.textView);
        String  name=getIntent().getStringExtra("name");
        t1.setText(name+"");
    }
}
