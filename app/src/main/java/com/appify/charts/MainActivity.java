package com.appify.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appify.charts.databinding.ActivityMainBinding;
import com.appify.charts.model.ChartData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<ChartData> chartData = new ArrayList<>();
        chartData.add(new ChartData("Active", 0));
        chartData.add(new ChartData("Away", 30));
        chartData.add(new ChartData("Pending", 0));

        binding.pieChart.setData(chartData);
        binding.pieChart.setText("Visitors");
    }
}