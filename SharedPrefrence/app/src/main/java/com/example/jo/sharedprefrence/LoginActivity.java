package com.example.jo.sharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init(){

        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        pass=findViewById(R.id.button5);
    }
    public void Pass(View view) {
        String emailValue=email.getText().toString();
        String PasswordValue=password.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences("testFile", Context.MODE_PRIVATE);
        String savedEmail=sharedPref.getString("email","jo");
        String savedpassword=sharedPref.getString("password","123");

        if (savedEmail.equals(emailValue) && savedpassword.equals(PasswordValue))
            Toast.makeText(LoginActivity.this,"login succefully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(LoginActivity.this,"login faild",Toast.LENGTH_LONG).show();



    }
}
