package com.example.jo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class custom_listView extends AppCompatActivity {
    ListView lv;
    ArrayList<social>socials=new ArrayList<social>();
    /*social []={
            new social("facebook",R.drawable.face),
            new social("twitter",R.drawable.twitter),
            new social("instagram",R.drawable.instagram1),
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        lv=(ListView)findViewById(R.id.lv_social);
        socials.add(new social("facebook",R.drawable.face));
        socials.add(new social("twitter",R.drawable.twitter));
        socials.add(new social("instagram",R.drawable.instagram1));
        socialAdapter adapter=new socialAdapter(custom_listView.this,socials);
        lv.setAdapter(adapter);
    }
}
