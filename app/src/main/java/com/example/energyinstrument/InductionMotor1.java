package com.example.energyinstrument;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InductionMotor1 extends AppCompatActivity {

    TextView format1;
    LinearLayout card1;
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
    }
}