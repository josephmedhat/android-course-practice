package com.example.jo.search;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class sitesActivity extends AppCompatActivity {

    Button bt_wyf ,bt_group,bt_plp,bt_go;
    EditText et_name;
    ImageView im_site_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);
        init();
    }

    public void init(){
        bt_wyf=findViewById(R.id.bt_wyf);
        bt_go=findViewById(R.id.bt_go);
        bt_group=findViewById(R.id.bt_group);
        bt_plp=findViewById(R.id.bt_plp);
        im_site_logo=findViewById(R.id.imv_logo);
        et_name=findViewById(R.id.et_name);
    }

    public void wyf(View view) {
        selected(bt_wyf);
        notSlected(bt_group);
        notSlected(bt_plp);

    }

    public void elite(View view) {
      selected(bt_group);
      notSlected(bt_wyf);
      notSlected(bt_plp);
    }

    public void plp(View view) {
        selected(bt_plp);
        notSlected(bt_wyf);
        notSlected(bt_group);
    }

    public void selected(Button bt){
        bt.setTextColor(Color.parseColor("#19CF9B"));
        bt.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
    public void notSlected(Button bt){
        bt.setTextColor(Color.parseColor("#0000000"));
        bt.setBackgroundColor(Color.parseColor("#00FFFFFF"));
    }

}
