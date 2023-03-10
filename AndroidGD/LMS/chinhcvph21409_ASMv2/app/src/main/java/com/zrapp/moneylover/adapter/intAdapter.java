package com.zrapp.moneylover.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.moneylover.model.ExpenseType;
import com.zrapp.moneylover.model.IncomeType;

import java.util.ArrayList;

public class intAdapter extends RecyclerView.Adapter<tHolder> {
    ArrayList<IncomeType> list;
    int LAYOUT;
    Context context;

    public intAdapter(ArrayList<IncomeType> list, int LAYOUT, Context context) {
        this.list = list;
        this.LAYOUT = LAYOUT;
        this.context = context;
    }

    @NonNull
    @Override
    public tHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        tHolder holder = new tHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull tHolder holder, int position) {
        IncomeType inT = list.get(position);
        holder.tvName.setText(inT.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
