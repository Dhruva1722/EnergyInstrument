package com.example.energyinstrument;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ACmfmCard1 extends AppCompatActivity {

    TextView format1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acmfm_card1);

        String dateTime;
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;

        format1 = findViewById(R.id.format2);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        format1.setText(dateTime);

    }
}