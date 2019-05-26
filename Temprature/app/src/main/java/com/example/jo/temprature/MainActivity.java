package com.example.jo.temprature;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button cal;
    RadioButton cel;
    RadioButton kel;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initiate();
    }

    public void Initiate() {
        input = (EditText) findViewById(R.id.temp);
        cal = (Button) findViewById(R.id.cal);
        group=(RadioGroup)findViewById(R.id.group);
        cel = (RadioButton) findViewById(R.id.cel);
        kel = (RadioButton) findViewById(R.id.kel);
    }


    public void Result(View view) {
        int result = 0;
        if (Validate()){
            DialogView("you should enter your value and select your choice");
            return;
        }
        String value = input.getText().toString();
        int TempValue = Integer.valueOf(value);
        if (cel.isChecked()){
            result = TempValue + 274;
            Log.d("click","cel");
        }

        else if (kel.isChecked()){
            result = TempValue - 274;
            Log.d("click","kel");

        }

        DialogView(String.valueOf(result));

    }

    public boolean Validate(){
        if (input.getText() == null || (!cel.isChecked() && !kel.isChecked())){
            return true;
        }
        return false;
    }

    public void DialogView(String Message) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("your Result");
        alertDialogBuilder.setMessage(Message);
        alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                input.getText().clear();
                group.clearCheck();
             //   finish();
            }
        });


        /*alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });*/

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

