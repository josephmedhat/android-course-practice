package com.example.jo.idapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ID;
    TextView city;
    TextView gender;
    TextView BD;
    Button show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID = (EditText) findViewById(R.id.identity);
        city = (TextView) findViewById(R.id.city);
        gender = (TextView) findViewById(R.id.gender);
        BD = (TextView) findViewById(R.id.bd);
        show = (Button) findViewById(R.id.show);

        if (savedInstanceState != null){
            city.setText(savedInstanceState.get("city").toString());
            gender.setText(savedInstanceState.get("gender").toString());
            BD.setText(savedInstanceState.get("bd").toString());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("city",city.getText().toString());
        outState.putString("gender",gender.getText().toString());
        outState.putString("bd",BD.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void show(View view) {
        Log.d("click", "show button");
        Reset();
        String id = ID.getText().toString();
        if (id.length() != 14) {
            Toast.makeText(MainActivity.this, "Invalid ID ", Toast.LENGTH_LONG).show();
        } else {
            id newString = new id(id);
            city.setText(newString.getCity());
            gender.setText(newString.getGender());
            BD.setText(newString.getBD());
        }


    }
    public void Reset() {
        city.setText("City");
        gender.setText("Gender");
        BD.setText("Date Of Birth");
    }
}
