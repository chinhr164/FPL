package com.zrapp.entertainment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.Activity.WebActivity;
import com.zrapp.entertainment.Model.News;
import com.zrapp.entertainment.R;

import java.util.ArrayList;

public class NewsHolder extends RecyclerView.ViewHolder {
    TextView title, descrip;
    ImageView img;
    Context context;
    ArrayList<News> list;

    public NewsHolder(@NonNull View itemView, Context context, ArrayList<News> list) {
        super(itemView);
        this.context = context;
        this.list = list;
        title = itemView.findViewById(R.id.tvTitle);
        descrip = itemView.findViewById(R.id.tvDescription);
        img = itemView.findViewById(R.id.imageV);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebActivity.class);
                Bundle bundle = new Bundle();
                News news = list.get(getLayoutPosition());
                bundle.putString("title", news.getTitle());
                bundle.putString("link", news.getLink());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }
}
