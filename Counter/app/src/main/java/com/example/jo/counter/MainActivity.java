package com.example.jo.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button inc;
    Button dec;
    Button reset;
    TextView value;
    counter c = new counter(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if (savedInstanceState != null){
            String val=savedInstanceState.get("count").toString();
            c.setCount(Integer.valueOf(val));
        }*/
        if (savedInstanceState != null){
            String val=savedInstanceState.get("count").toString();
            value.setText(val);
        }
        init();


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("count",value.getText().toString());
        super.onSaveInstanceState(outState);
    }

/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("count",c.getCount()+"");
        super.onSaveInstanceState(outState);
    }
*/

    public void init() {
        inc = (Button) findViewById(R.id.inc);
        dec = (Button) findViewById(R.id.dec);
        reset = (Button) findViewById(R.id.reset);
        value = (TextView) findViewById(R.id.value);
        value.setText(c.getCount()+"");
    }

    public void increment(View view) {
        c.increment();
        //Log.d("counter",c.getCount()+"");
        value.setText(c.getCount()+"");
    }

    public void decrement(View view) {
        c.decrement();
        value.setText(c.getCount()+"");
    }

    public void Reset(View view) {
        c.reset();
        value.setText(c.getCount()+"");
    }
}
