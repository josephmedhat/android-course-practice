package com.example.jo.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    Button lv;
    Button clv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    public void init(){
        lv=(Button)findViewById(R.id.bt_lv);
        clv=(Button)findViewById(R.id.bt_clv);
    }

    public void clv(View view) {
        Intent i=new Intent(Main3Activity.this,custom_listView.class);
        startActivity(i);
    }

    public void lv(View view) {
        Intent i=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(i);
    }
}
