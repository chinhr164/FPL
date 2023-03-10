package com.zrapp.moneylover.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.moneylover.R;


public class exsHolder extends RecyclerView.ViewHolder {
    TextView tvName, tvPrice, tvDate,  tvUser;
    ImageView ibtn_info;
    LinearLayout layout;


    public exsHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.ed_s_ex_name);
        tvPrice = itemView.findViewById(R.id.ed_s_ex_price);
        ibtn_info = itemView.findViewById(R.id.btn_s_ex_info);
        tvDate = itemView.findViewById(R.id.row_s_ex_date);
        tvUser = itemView.findViewById(R.id.row_s_ex_user);
        layout = itemView.findViewById(R.id.row_s_ex_content);
    }
}
