package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProdViewHolder> {
    ArrayList<Product> list = new ArrayList<>();

    public ProductAdapter(ArrayList<Product> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.layout_item,parent,false);
        ProdViewHolder holder = new ProdViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdViewHolder holder, int position) {
        //tuỳ chỉnh cho view
        Product p = list.get(position);
        holder.img_res.setImageResource(p.getImg_res());
        holder.info_prod.setText(p.getId()+ " - " + p.getName());

        //Khai báo biến thứ tự
        final int index = position;
        holder.img_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(index);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
