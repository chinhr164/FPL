package com.zrapp.entertainment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.Model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    ArrayList<News> list;
    Context context;
    int LAYOUT;

    public NewsAdapter(ArrayList<News> list, Context context, int LAYOUT) {
        this.list = list;
        this.context = context;
        this.LAYOUT = LAYOUT;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        NewsHolder holder = new NewsHolder(row, context, list);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news = list.get(position);
        holder.title.setText(news.getTitle());
        holder.descrip.setText(news.getDes());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
