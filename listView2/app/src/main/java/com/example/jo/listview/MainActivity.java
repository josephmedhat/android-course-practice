package com.example.jo.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button lv;
    Button c_lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(Button)findViewById(R.id.b_lv);
        c_lv=(Button)findViewById(R.id.c_lv);
    }

    public void lv(View view) {
        Intent i=new Intent(MainActivity.this,ListViewActivity.class);
        startActivity(i);
    }

    public void custom(View view) {
        Intent i=new Intent(MainActivity.this,customListView.class);
        startActivity(i);
    }
}
