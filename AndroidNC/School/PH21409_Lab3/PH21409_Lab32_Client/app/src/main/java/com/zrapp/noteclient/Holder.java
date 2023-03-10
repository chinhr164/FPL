package com.zrapp.noteclient;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    TextView tvTitle, tvContent;
    ImageView btnInfo;
    LinearLayout layout;

    public Holder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvContent = itemView.findViewById(R.id.tvContent);
        layout = itemView.findViewById(R.id.rcv_content);
        btnInfo = itemView.findViewById(R.id.btnInfo);
    }
}
