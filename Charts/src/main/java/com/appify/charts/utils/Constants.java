package com.appify.charts.utils;

import android.graphics.Color;

import com.appify.charts.model.ChartData;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String BASE_URL = "https://api.github.com/";

    public static final String LOGIN = "login";

    public static List<Integer> getColors() {
        List<Integer> colors = new ArrayList<>();

        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.MAGENTA);
        colors.add(Color.CYAN);
        colors.add(Color.DKGRAY);
        colors.add(Color.YELLOW);
        colors.add(Color.LTGRAY);

        return colors;
    }

    public static List<ChartData> getChartData() {
        List<ChartData> data = new ArrayList<>();

        data.add(new ChartData("Football", 300));
        data.add(new ChartData("Football", 300));
        data.add(new ChartData("Football", 300));
        data.add(new ChartData("Football", 300));
        data.add(new ChartData("Football", 300));

        return data;
    }
}
