package com.example.jo.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button4);
       // Log.d("create","activity cretaed");
    }

    public void show(View view) {
        //Log.d("create","button clicked");
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);

    }
}
