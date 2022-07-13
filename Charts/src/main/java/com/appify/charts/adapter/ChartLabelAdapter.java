package com.appify.charts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appify.charts.R;
import com.appify.charts.databinding.ChartRowDataBinding;
import com.appify.charts.model.ChartData;

import java.util.List;

public class ChartLabelAdapter extends RecyclerView.Adapter<ChartLabelAdapter.Holder> {
    private List<ChartData> dataList;
    private List<Integer> colorList;

    public ChartLabelAdapter(List<ChartData> dataList, List<Integer> colorList) {
        this.dataList = dataList;
        this.colorList = colorList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_row_data, parent, false);
        ChartRowDataBinding binding = ChartRowDataBinding.bind(view);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.button.setBackgroundColor(colorList.get(position));
        holder.chartLabel.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        Button button;
        TextView chartLabel;

        public Holder(@NonNull ChartRowDataBinding binding) {
            super(binding.getRoot());
            button = binding.button;
            chartLabel = binding.chartLabel;
        }
    }
}
