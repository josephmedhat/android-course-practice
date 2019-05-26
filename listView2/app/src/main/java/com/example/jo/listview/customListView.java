package com.example.jo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class customListView extends AppCompatActivity {
    ListView clv;
    String socials[] ={"facebook","twitter","instagram"};
    int images[]={R.drawable.face,R.drawable.twitter,R.drawable.instagram1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        clv=(ListView)findViewById(R.id.clv);

        myAdapter adapter=new myAdapter(customListView.this,socials,images);
        clv.setAdapter(adapter);
    }
}
