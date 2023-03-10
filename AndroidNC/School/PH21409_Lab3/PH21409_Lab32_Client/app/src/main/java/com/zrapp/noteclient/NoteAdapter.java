package com.zrapp.noteclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<Holder> {
    ArrayList<Notes> list;
    int LAYOUT;
    Context context;

    public NoteAdapter(ArrayList<Notes> list, int LAYOUT, Context context) {
        this.list = list;
        this.LAYOUT = LAYOUT;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        Holder holder = new Holder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Notes note = list.get(position);
        holder.tvTitle.setText(note.getId() + " - " + note.getTitle());
        holder.tvContent.setText(note.getContent());

        /* Bắt đầu xử lý ẩn/hiện thông tin */
        Animation animationUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        Animation animationDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

        holder.btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.layout.isShown()) {
                    holder.layout.setVisibility(View.GONE);
                    holder.layout.startAnimation(animationUp);
                    holder.btnInfo.setImageResource(R.drawable.ic_collapse);
                } else {
                    holder.layout.setVisibility(View.VISIBLE);
                    holder.layout.startAnimation(animationDown);
                    holder.btnInfo.setImageResource(R.drawable.ic_expand);
                }
            }
        });
        /* Kết thúc xử lý ẩn/hiện thông tin */
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
