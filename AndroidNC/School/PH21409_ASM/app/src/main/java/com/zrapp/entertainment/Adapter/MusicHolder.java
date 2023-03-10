package com.zrapp.entertainment.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.zrapp.entertainment.Frag.FragMusic;
import com.zrapp.entertainment.Model.Song;
import com.zrapp.entertainment.R;
import com.zrapp.entertainment.Services.MusicService;

import java.util.ArrayList;

public class MusicHolder extends RecyclerView.ViewHolder {
    TextView title, author;
    ArrayList<Song> list;

    public MusicHolder(@NonNull View itemView, ArrayList<Song> list) {
        super(itemView);
        this.list = list;
        title = itemView.findViewById(R.id.musicTitle);
        author = itemView.findViewById(R.id.musicAuthor);
        itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MusicService.list = list;
                        for (int i = 0; i < list.size(); i++) {
                            String s = list.get(i).getTitle();
                            if (s.equals(title.getText().toString())) {
                                FragMusic.service.selectSong( i);
                                FragMusic.sheetMusic.setState(BottomSheetBehavior.STATE_EXPANDED);
                                break;
                            }
                        }
                    }
                }
        );
    }
}
