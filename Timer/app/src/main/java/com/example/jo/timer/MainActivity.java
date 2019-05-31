package com.example.jo.timer;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    int SelectedProgress=0;
    Button go;
    TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public  void UpdateTimer(int remainder){
        int minutes=remainder/60;
        int seconds=remainder-minutes*60;
        String MinutesS=String.valueOf(minutes);
        String SecondsS=String.valueOf(seconds);
        if (minutes <=9){
            MinutesS="0"+MinutesS;
        }
        if (seconds<10)
            SecondsS="0"+SecondsS;

        timer.setText(MinutesS+":"+SecondsS);

    }

    public void SeekBarSetting(SeekBar seekBar){
        seekBar.setMax(600);
        seekBar.setProgress(10);
        UpdateTimer(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    UpdateTimer((int)progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void init(){
        seekBar=(SeekBar)findViewById(R.id.seekBar3);
        go=(Button)findViewById(R.id.button);
        timer=(TextView)findViewById(R.id.textView);
        SeekBarSetting(seekBar);
    }


    public void go(View view) {
        SelectedProgress=seekBar.getProgress();
        seekBar.setVisibility(View.INVISIBLE);
        new CountDownTimer(SelectedProgress * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                UpdateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                makeDialog();
                MediaPlayer alert=MediaPlayer.create(MainActivity.this,R.raw.boom);
                alert.start();
                seekBar.setVisibility(View.VISIBLE);
            }
        }.start();
    }


    public void makeDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Time Out!");
        builder.setMessage("Finished "+(float)SelectedProgress/60 +" Minutes" );
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}
