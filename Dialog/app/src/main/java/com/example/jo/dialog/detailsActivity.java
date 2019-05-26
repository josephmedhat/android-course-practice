package com.example.jo.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView=(TextView)findViewById(R.id.textView2);
        textView.setText(getIntent().getStringExtra("name"));
    }
}
