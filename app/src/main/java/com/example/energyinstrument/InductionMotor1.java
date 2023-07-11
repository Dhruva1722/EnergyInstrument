package com.example.energyinstrument;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class InductionMotor1 extends AppCompatActivity {

    TextView format1;
    LinearLayout card1;

    LineChart lineChart;
    List<String> xValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_induction_motor1);


        String dateTime;
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;

        format1 = findViewById(R.id.format1);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format1.setText(dateTime);

        card1 = findViewById(R.id.ly5_card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InductionMotor1.this,piechart.class);
                startActivity(intent);
            }
        });


        lineChart = findViewById(R.id.linechart);


        lineChart.getAxisRight().setDrawLabels(false);


        xValues = Arrays.asList("1","2","3","4","5","6","7");

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
        xAxis.setLabelCount(5);
        xAxis.setGranularity(1f);




        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(50f);
        yAxis.setAxisLineWidth(2f);
        yAxis.setAxisLineColor(Color.BLACK);
        yAxis.setLabelCount(7);


        List<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(0,10f));
        entries1.add(new Entry(1,30f));
        entries1.add(new Entry(2,15f));
        entries1.add(new Entry(3,22f));
        entries1.add(new Entry(4,25f));
        entries1.add(new Entry(5,20f));
        entries1.add(new Entry(6,25f));

        List<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(0,38f));
        entries2.add(new Entry(1,15f));
        entries2.add(new Entry(2,25f));
        entries2.add(new Entry(3,10f));
        entries2.add(new Entry(4,26f));
        entries2.add(new Entry(5,10f));
        entries2.add(new Entry(6,26f));


        List<Entry> entries3 = new ArrayList<>();
        entries3.add(new Entry(0,30f));
        entries3.add(new Entry(1,44f));
        entries3.add(new Entry(2,35f));
        entries3.add(new Entry(3,42f));
        entries3.add(new Entry(4,29f));
        entries3.add(new Entry(5,42f));
        entries3.add(new Entry(6,29f));


        LineDataSet lineDataSet1 = new LineDataSet(entries1,"L1");
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(entries2,"L2");
        lineDataSet2.setColor(Color.RED);

        LineDataSet lineDataSet3 = new LineDataSet(entries3,"L3");
        lineDataSet3.setColor(Color.YELLOW);

        LineData lineData = new LineData(lineDataSet1,lineDataSet2,lineDataSet3);
        lineChart.setData(lineData);

        lineChart.invalidate();

    }
}