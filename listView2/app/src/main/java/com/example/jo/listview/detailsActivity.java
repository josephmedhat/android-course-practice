package com.example.jo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detailsActivity extends AppCompatActivity {
    TextView details;
    final String socials []={
            "facebook","Twitter","LinkedIn","Instagram",
            "facebook","Twitter","LinkedIn","Instagram",
            "facebook","Twitter","LinkedIn","Instagram",
            "facebook","Twitter","LinkedIn","Instagram",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        details=(TextView)findViewById(R.id.tv_details);
        int val=getIntent().getIntExtra("index",0);
        details.setText(socials[val]);
    }
}
