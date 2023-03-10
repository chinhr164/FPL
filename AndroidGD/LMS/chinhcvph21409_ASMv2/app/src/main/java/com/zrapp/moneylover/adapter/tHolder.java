package com.zrapp.moneylover.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.moneylover.R;

public class tHolder extends RecyclerView.ViewHolder {
    public TextView tvName;

    public tHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.ed_t_name);
    }
}
