package com.example.energyinstrument;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class piechart extends AppCompatActivity {

    TextView tvkwh, tvvoltage, tvcurrent, tvwalt, tvshuntvalue;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);




        tvkwh = findViewById(R.id.tvkwh);
        tvvoltage = findViewById(R.id.tvvoltage);
        tvcurrent = findViewById(R.id.tvcurrent);
        tvwalt = findViewById(R.id.tvwalt);
        tvshuntvalue = findViewById(R.id.tvvalue);


        pieChart = findViewById(R.id.piechart);

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();
    }
    private void setData()
    {

        // Set the percentage of language used
        tvkwh.setText(Integer.toString(50));
        tvvoltage.setText(Integer.toString(30));
        tvcurrent.setText(Integer.toString(5));
        tvwalt.setText(Integer.toString(25));
        tvshuntvalue.setText(Integer.toString(25));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "KWh",
                        Integer.parseInt(tvkwh.getText().toString()),
                        Color.parseColor("#7E89CD")));
        pieChart.addPieSlice(
                new PieModel(
                        "Voltage",
                        Integer.parseInt(tvvoltage.getText().toString()),
                        Color.parseColor("#5A649F")));
        pieChart.addPieSlice(
                new PieModel(
                        "Current",
                        Integer.parseInt(tvcurrent.getText().toString()),
                        Color.parseColor("#8797ED")));
        pieChart.addPieSlice(
                new PieModel(
                        "Walt",
                        Integer.parseInt(tvwalt.getText().toString()),
                        Color.parseColor("#41486F")));

        pieChart.addPieSlice(
                new PieModel(
                        "ShuntValue",
                        Integer.parseInt(tvshuntvalue.getText().toString()),
                        Color.parseColor("#C7CCE8")));
        // To animate the pie chart
        pieChart.startAnimation();
    }
}