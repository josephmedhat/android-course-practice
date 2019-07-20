package com.example.jo.search;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    TextView tv_email,tv_password;
    Button login;
    ImageView logo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public boolean validate(){
        if (email.getText().toString().equals("") || password.getText().toString().equals("") ){
            Toast.makeText(MainActivity.this,"please Enter EMAIL AND Password ",Toast.LENGTH_LONG).show();
            return false;
        }
        else
            return true;

    }

    public void init(){
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        tv_email=findViewById(R.id.tv_emailLabel);
        tv_password=findViewById(R.id.tv_passwordLabel);
        login=findViewById(R.id.bt_login);
        logo=findViewById(R.id.imv_logo);
    }

    public void login(View view) {
        if (validate())
            startActivity(new Intent(MainActivity.this,sitesActivity.class));

    }
}
