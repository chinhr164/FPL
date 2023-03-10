package com.example.chinhcvph21409_lab3_01;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public ImageButton ibtn_edit, ibtn_del;
    public ImageView  img_res;
    public TextView user_info;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        img_res = itemView.findViewById(R.id.user_img);
        ibtn_edit = itemView.findViewById(R.id.ibtn_edit);
        ibtn_del = itemView.findViewById(R.id.ibtn_del);
        user_info = itemView.findViewById(R.id.user_info);
    }
}
