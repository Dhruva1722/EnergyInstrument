package com.example.energyinstrument;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

public class piechart extends AppCompatActivity {

    TextView tvkwh, tvvoltage, tvcurrent, tvwalt, tvshuntvalue;
    PieChart pieChart;

    LinearLayout linearLayoutKWH;
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;

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

    private void setData() {

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


        linearLayoutKWH = findViewById(R.id.lyKWH);

        linearLayoutKWH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });


    }

    private void showPopup() {
        // Inflate the popup layout
        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.kwh_popup_box, null);



        barChart = popupView.findViewById(R.id.idBarChart);
        barChart.getAxisRight().setDrawLabels(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        getBarEntries();

        // creating a new bar data set.
        barDataSet = new BarDataSet(barEntriesArrayList, "KWh Hourly Report");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);
        barChart.setData(barData);

        // adding color to our bar data set.
        barDataSet.setColors(Color.BLUE);

        // setting text color.
        barDataSet.setValueTextColor(Color.BLACK);

        // setting text size
        barDataSet.setValueTextSize(10);
        barChart.getDescription().setEnabled(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(piechart.this);
        builder.setView(popupView);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void getBarEntries() {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntriesArrayList.add(new BarEntry(1f, 4));
        barEntriesArrayList.add(new BarEntry(2f, 6));
        barEntriesArrayList.add(new BarEntry(3f, 8));
        barEntriesArrayList.add(new BarEntry(4f, 2));
        barEntriesArrayList.add(new BarEntry(5f, 4));
        barEntriesArrayList.add(new BarEntry(6f, 5));
        barEntriesArrayList.add(new BarEntry(7f, 8));
        barEntriesArrayList.add(new BarEntry(8f, 3));
        barEntriesArrayList.add(new BarEntry(9f, 1));
        barEntriesArrayList.add(new BarEntry(10f, 5));
        barEntriesArrayList.add(new BarEntry(11f, 5));
        barEntriesArrayList.add(new BarEntry(12f, 3));
    }

}
