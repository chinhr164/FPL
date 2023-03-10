package com.zrapp.moneylover.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.moneylover.R;


public class insHolder extends RecyclerView.ViewHolder {
    TextView tvName, tvPrice, tvDate,  tvUser;
    ImageView ibtn_info;
    LinearLayout layout;


    public insHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.ed_s_in_name);
        tvPrice = itemView.findViewById(R.id.ed_s_in_price);
        ibtn_info = itemView.findViewById(R.id.btn_s_in_info);
        tvDate = itemView.findViewById(R.id.row_s_in_date);
        tvUser = itemView.findViewById(R.id.row_s_in_user);
        layout = itemView.findViewById(R.id.row_s_in_content);
    }
}
