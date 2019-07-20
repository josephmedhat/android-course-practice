package com.example.jo.sharedprefrence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    TextView data;
    Button save, load,login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        name = (EditText) findViewById(R.id.name);
        data = (TextView) findViewById(R.id.textView);
        load = findViewById(R.id.button);
        save = findViewById(R.id.button2);
        login = findViewById(R.id.button3);
        register = findViewById(R.id.button4);

    }

    public void save(View view) {
        SharedPreferences sharedPref = getSharedPreferences("testFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", name.getText().toString());
        editor.apply();
        Toast.makeText(MainActivity.this,"data saved succefully",Toast.LENGTH_LONG).show();
    }

    public void load(View view) {
        SharedPreferences sharedPref = getSharedPreferences("testFile", Context.MODE_PRIVATE);
        data.setText(sharedPref.getString("name", "NO Name"));
    }

    public void login(View view) {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    public void register(View view) {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
    }
}
