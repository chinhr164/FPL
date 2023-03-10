package com.zrapp.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<Holder> {
    ArrayList<NewsDTO> list;
    Context context;
    int LAYOUT;

    public NewsAdapter(ArrayList<NewsDTO> list, Context context, int LAYOUT) {
        this.list = list;
        this.context = context;
        this.LAYOUT = LAYOUT;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        Holder holder = new Holder(row, context, list);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        NewsDTO news = list.get(position);
        holder.title.setText(news.getTitle());
        holder.descrip.setText(news.getDescip());
        Picasso.get().load(news.getImg()).fit().into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
