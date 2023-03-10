package com.zrapp.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Holder extends RecyclerView.ViewHolder{
    TextView title, descrip;
    ImageView img;
    Context context;
    ArrayList<NewsDTO> list;

    public Holder(@NonNull View itemView, Context context, ArrayList<NewsDTO> list) {
        super(itemView);
        this.context = context;
        this.list = list;
        title = itemView.findViewById(R.id.tvTitle);
        descrip = itemView.findViewById(R.id.tvDescription);
        img = itemView.findViewById(R.id.imageV);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewActivity.class);
                Bundle bundle = new Bundle();
                NewsDTO news = list.get(getLayoutPosition());
                bundle.putString("title",news.getTitle());
                bundle.putString("link",news.getLink());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }


}
