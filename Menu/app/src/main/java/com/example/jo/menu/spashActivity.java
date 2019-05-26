package com.example.jo.menu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class spashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);


       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
                startActivity(new Intent(spashActivity.this,MainActivity.class));
           }
       },4000);

    }
}
