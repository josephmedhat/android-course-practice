package com.example.jo.recipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView y;
    Button x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();
    }

    public void show(View view) {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        Log.d("launch","created");

        startActivity(i);
        Log.d("launch","go");
    }
    public void inti(){
        y=(ImageView)findViewById(R.id.pic);
        x=(Button)findViewById(R.id.Recipes_button);
    }
}
