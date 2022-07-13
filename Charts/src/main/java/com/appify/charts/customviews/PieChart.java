package com.appify.charts.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.appify.charts.model.ChartData;
import com.appify.charts.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class PieChart extends View {
    private List<ChartData> data;
    private List<Integer> colors;
    private Paint textPaint;
    private Paint smallCirclePaint;
    private Paint outerCirclePaint;
    private RectF oval;
    private String text = "";
    private int smallRadius;
    private int largeRadius;
    private int midX = 0;
    private int midY = 0;

    public PieChart(Context context) {
        super(context);

        init();
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        data = new ArrayList<>();

        colors = Constants.getColors();

        oval = new RectF();

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.CENTER);

        smallCirclePaint = new Paint();
        smallCirclePaint.setColor(Color.WHITE);
        smallCirclePaint.setStyle(Paint.Style.FILL);

        outerCirclePaint = new Paint();
        outerCirclePaint.setStyle(Paint.Style.FILL);
        outerCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        midX = getWidth()/2;
        midY = getHeight()/2;
        smallRadius = midY - 60;
        largeRadius = midY;

        oval.set(0, 0, midX+largeRadius, midY+largeRadius);

        if (data.size()>0) {
            float startAngle = -90;
            float sweepAngle = 360/(float)data.size();
            for (int i=0; i<data.size(); i++) {
                outerCirclePaint.setColor(colors.get(i));
                canvas.drawArc(oval, startAngle, sweepAngle, true, outerCirclePaint);
                startAngle += sweepAngle;
            }
        }

        canvas.drawCircle(midX, midY, smallRadius, smallCirclePaint);
        canvas.drawText(text, midX, midY-(textPaint.descent()+textPaint.ascent())/2, textPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int w = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(w, w);
    }

    public void setData(List<ChartData> data) {
        this.data = data;
        invalidate();
    }

    public void setColors(List<Integer> colors) {
        if (colors.size() < data.size()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.colors = colors;
        invalidate();
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }
}
