package com.example.jo.recipes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView lv;

        final String[] recipes={"Koshary","Samak","kofta"};

        final String[] ingredients={"roz,3ts,makarona,salsa,basal","samak,tom,mal7,kamoon","l7ma mfroma,basal,boharat"};

        lv=(ListView)findViewById(R.id.lv_recipes);

        ArrayAdapter<String>x=new ArrayAdapter<>(Main2Activity.this ,android.R.layout.simple_list_item_1,recipes);
        lv.setAdapter(x);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle(""+recipes[position]);
                builder.setMessage("ARE YOU SURE TO SHOW FULL INGREDIENTS OF "+recipes[position]);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                        i.putExtra("value",ingredients[position]);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();

            }
        });



    }

}
