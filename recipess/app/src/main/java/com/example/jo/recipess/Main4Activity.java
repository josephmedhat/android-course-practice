package com.example.jo.recipess;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    ImageView image ;
    Button button2;
    String ingredients []={
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",

    };
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        image =(ImageView)findViewById(R.id.imageView);
        button2=(Button)findViewById(R.id.button2);
        num= getIntent().getIntExtra("value",0);
        int[] images = {
                R.drawable.pizza123,
                R.drawable.pizza123,
                R.drawable.pizza123,
                R.drawable.pizza123,
                R.drawable.pizza123,
        };


        image.setImageResource(images[num]);






    }

    public void show(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Main4Activity.this);
        builder.setTitle("Ingredient");
        builder.setMessage(ingredients[num]);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
