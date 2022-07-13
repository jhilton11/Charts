package com.appify.charts.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appify.charts.R;
import com.appify.charts.adapter.ChartLabelAdapter;
import com.appify.charts.model.ChartData;
import com.appify.charts.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class CompoundPieChart extends LinearLayout {
    private PieChart pieChart;
    private RecyclerView recyclerView;
    private List<Integer> colors;
    private List<ChartData> dataList;
    private LinearLayoutManager layoutManager;

    public CompoundPieChart(Context context) {
        super(context);

        init(context);
    }

    public CompoundPieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.compound_pie_chart, this);
        pieChart = findViewById(R.id.pie_chart);
        recyclerView = findViewById(R.id.recyclerview);
        dataList = new ArrayList<>();
        colors = Constants.getColors();
        layoutManager = new LinearLayoutManager(context.getApplicationContext());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        recyclerView.setLayoutManager(layoutManager);
    }

    public void setColors(List<Integer> colors) {
        this.colors = colors;
        if (dataList.size() > 0) {
            setData(dataList);
        }
    }

    public void setData(List<ChartData> data) {
        this.dataList = data;
        pieChart.setData(data);
        ChartLabelAdapter adapter = new ChartLabelAdapter(dataList, colors);
        recyclerView.setAdapter(adapter);
    }

    public void setText(String text) {
        pieChart.setText(text);
    }
}
