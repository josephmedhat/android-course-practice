package com.example.jo.charts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class LineChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        com.github.mikephil.charting.charts.LineChart chart = (com.github.mikephil.charting.charts.LineChart) findViewById(R.id.chart);
        ArrayList<Entry> values = new ArrayList<>();
        values.add(new Entry(2007, 10));
        values.add(new Entry(2008, 18));
        values.add(new Entry(2009, 25));
        values.add(new Entry(2010, 5));
        values.add(new Entry(2011, 3));
        values.add(new Entry(2012, 30));
        LineDataSet dataSet = new LineDataSet(values, "first chart "); // add entries to dataset
        dataSet.setColor(R.color.colorPrimary);
        LineData lineData = new LineData(dataSet);
        dataSet.setDrawFilled(true);
        chart.setData(lineData);
        chart.invalidate(); // refresh
        chart.animateXY(2000,2000);
    }
}
