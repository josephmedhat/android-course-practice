package com.example.jo.recipess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final String recipes []={"margareta","vegetarians","tuna","roma","sea food"};
        list=(ListView)findViewById(R.id.list);
        ArrayAdapter<String> x=new ArrayAdapter<String>(Main3Activity.this,android.R.layout.simple_list_item_1,recipes);
        list.setAdapter(x);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main3Activity.this,recipes[position],Toast.LENGTH_LONG).show();
                Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                i.putExtra("value",position);
                startActivity(i);
            }
        });
    }
}
