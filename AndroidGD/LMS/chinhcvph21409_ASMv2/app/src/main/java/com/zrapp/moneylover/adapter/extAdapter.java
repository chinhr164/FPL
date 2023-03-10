package com.zrapp.moneylover.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.moneylover.model.ExpenseType;

import java.util.ArrayList;

public class extAdapter extends RecyclerView.Adapter<tHolder> {
    ArrayList<ExpenseType> list;
    int LAYOUT;
    Context context;

    public extAdapter(ArrayList<ExpenseType> list, int LAYOUT, Context context) {
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
        ExpenseType ext = list.get(position);
        holder.tvName.setText(ext.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
