package com.example.jo.listview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv=(ListView)findViewById(R.id.lv_items);

        final String socials []={
                "facebook","Twitter","LinkedIn","Instagram",
                "facebook","Twitter","LinkedIn","Instagram",
                "facebook","Twitter","LinkedIn","Instagram",
                "facebook","Twitter","LinkedIn","Instagram",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1,socials);
        lv.setAdapter(adapter);
        Log.d("adapter","adapted");

       /* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,position+"",Toast.LENGTH_LONG).show();
            }
        });*/

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

               AlertDialog.Builder builder=new AlertDialog.Builder(ListViewActivity.this);
               builder.setTitle("Show");
               builder.setMessage(socials[position]);
               builder.setPositiveButton("show details", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                            Intent i= new Intent(ListViewActivity.this,detailsActivity.class);
                            i.putExtra("index",position);
                            startActivity(i);
                   }
               });

               AlertDialog alertDialog=builder.create();
               alertDialog.show();
               Toast.makeText(ListViewActivity.this,socials[position]+"",Toast.LENGTH_LONG).show();

           }
       });
    }
}
