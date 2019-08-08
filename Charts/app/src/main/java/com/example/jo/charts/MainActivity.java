package com.example.jo.charts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*
        Button b=(Button)findViewById(R.id.bt_line);
        Log.d("run","created");*/
    }

    public void lineChart(View view) {
        startActivity(new Intent(MainActivity.this, com.example.jo.charts.LineChart.class));
    }

    public void progress(View view) {
        startActivity(new Intent(MainActivity.this, com.example.jo.charts.Progress.class));

    }
}
