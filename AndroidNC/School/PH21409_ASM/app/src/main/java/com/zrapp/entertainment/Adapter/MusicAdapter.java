package com.zrapp.entertainment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.Model.Song;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicHolder> {
    ArrayList<Song> list;
    Context context;
    int LAYOUT;

    public MusicAdapter(ArrayList<Song> list, Context context, int LAYOUT) {
        this.list = list;
        this.context = context;
        this.LAYOUT = LAYOUT;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        MusicHolder holder = new MusicHolder(row,list);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
        Song song = list.get(position);
        holder.title.setText(song.getTitle());
        holder.author.setText(song.getArtist());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
