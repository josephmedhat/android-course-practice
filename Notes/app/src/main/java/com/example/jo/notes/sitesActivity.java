package com.example.jo.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class sitesActivity extends AppCompatActivity {
    CardView card1,card2,card3;
    TextView tv_no5ba,tv_coming;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);
    }
    public void init(){
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        tv_coming=findViewById(R.id.tv_coming);
        tv_no5ba=findViewById(R.id.tv_no5ba);
    }

    public void event(View view) {
        startActivity(new Intent(this,SearchMainActivity.class));

    }
}
