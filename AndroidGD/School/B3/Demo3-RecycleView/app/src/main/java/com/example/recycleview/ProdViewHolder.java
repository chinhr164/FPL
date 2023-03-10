package com.example.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProdViewHolder extends RecyclerView.ViewHolder {
    public ImageView img_res, img_del;
    public TextView info_prod;

    public ProdViewHolder(View itemView) {
        super(itemView);
            img_res = itemView.findViewById(R.id.img_prod);
            info_prod = itemView.findViewById(R.id.prod_info);
            img_del = itemView.findViewById(R.id.delete_prod);
    }
}
