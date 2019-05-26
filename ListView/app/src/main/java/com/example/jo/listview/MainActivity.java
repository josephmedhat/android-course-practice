package com.example.jo.listview;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        final String names[] ={"facebook","twitter","instagram"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,names);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("name",names[position]);
                Toast.makeText(MainActivity.this,names[position]+"",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}
