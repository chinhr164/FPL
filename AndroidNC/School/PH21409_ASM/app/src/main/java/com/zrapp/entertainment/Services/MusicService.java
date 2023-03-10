package com.zrapp.entertainment.Services;

import static com.zrapp.entertainment.Frag.FragMusic.binding;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.Adapter.MusicAdapter;
import com.zrapp.entertainment.Frag.FragMusic;
import com.zrapp.entertainment.Model.Song;
import com.zrapp.entertainment.R;
import com.zrapp.entertainment.SQLite.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MusicService extends IntentService {
    public static MediaPlayer player;
    private int postion;
    private int time;
    Context context;
    public static ArrayList<Song> list = new ArrayList<>();
    public static DAO dao;

    public MusicService() {
        super("MusicService");
    }

    public MusicService(Context context) {
        super("MusicService");
        this.context = context;
        dao = new DAO(context);
    }

    private final IBinder iBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {return null;}

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        context = getBaseContext();
        dao = new DAO(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
        }
    }

    public void loadSong() {
        String[] projection = {
                MediaStore.MediaColumns.TITLE,
                MediaStore.MediaColumns.ARTIST,
                MediaStore.MediaColumns.DATA
        };
        Cursor c = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection, MediaStore.Audio.Media.DURATION + ">?", new String[]{"6000"}, null);
        list.clear();
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song song = new Song();
            song.setTitle(c.getString(0));
            song.setArtist(c.getString(1));
            song.setPath(c.getString(2));
            list.add(song);
            c.moveToNext();
        }
        c.close();
    }

    public void loadFavSong() {
        list.clear();
        for (int i = 0; i < dao.getFavorList().size(); i++) {
            list.add(dao.getFavorList().get(i));
        }
    }

    public void loadList(RecyclerView rcv) {
        if (rcv.getId() == R.id.music_rcv) {
            loadSong();
        } else {
            loadFavSong();
        }
        MusicAdapter adapter = new MusicAdapter(list, context, R.layout.item_row_music);
        rcv.setAdapter(adapter);
    }

    public void newTrack() {
        Song song = list.get(postion);
        Uri uri = Uri.parse(song.getPath());
        player = MediaPlayer.create(context, uri);
        binding.layoutPlayer.musicSong.setText(song.getTitle());
        binding.bmusicSong.setText(song.getTitle());
        binding.layoutPlayer.fmusicSong.setText(song.getTitle());
        binding.layoutPlayer.musicAuthor.setText(song.getArtist());
        binding.bmusicAuthor.setText(song.getArtist());
        binding.layoutPlayer.fmusicAuthor.setText(song.getArtist());
        for (int i = 0; i < dao.getFavorList().size(); i++) {
            String s = dao.getFavorList().get(i).getTitle();
            if (s.equals(song.getTitle())) {
                binding.layoutPlayer.musicFavorite.setImageResource(R.drawable.ic_favorited);
                break;
            }
            binding.layoutPlayer.musicFavorite.setImageResource(R.drawable.ic_favorite);
        }
        setEndTime();
    }

    public void selectSong(int postionS) {
        player.stop();
        postion = postionS;
        newTrack();
        play();
    }

    public void play() {
        if (player.isPlaying()) {
            player.pause();
            binding.layoutPlayer.musicPlay.setImageResource(R.drawable.ic_play);
            binding.bmusicPlay.setImageResource(R.drawable.ic_play);
            binding.layoutPlayer.fmusicPlay.setImageResource(R.drawable.ic_play);
            binding.layoutPlayer.musicDisc.clearAnimation();
        } else {
            player.start();
            binding.layoutPlayer.musicPlay.setImageResource(R.drawable.ic_pause);
            binding.bmusicPlay.setImageResource(R.drawable.ic_pause);
            binding.layoutPlayer.fmusicPlay.setImageResource(R.drawable.ic_pause);
            binding.layoutPlayer.musicDisc.startAnimation(FragMusic.anim);
        }
        setEndTime();
        setRealTime();
    }

    public void prev() {
        if (binding.layoutPlayer.musicShuffle.getDrawable().getConstantState() == context.getResources().getDrawable(R.drawable.ic_shuffle_none).getConstantState())
            postion--;
        else
            postion = (int) (Math.random() * list.size());
        if (postion < 0)
            postion = list.size() - 1;
        if (player.isPlaying()) {
            player.stop();
            player.release();
        }
        binding.layoutPlayer.musicPlay.setImageResource(R.drawable.ic_pause);
        binding.bmusicPlay.setImageResource(R.drawable.ic_pause);
        binding.layoutPlayer.fmusicPlay.setImageResource(R.drawable.ic_pause);
        newTrack();
        player.start();
        setEndTime();
        setRealTime();
    }

    public void next() {
        if (binding.layoutPlayer.musicShuffle.getDrawable().getConstantState() == context.getResources().getDrawable(R.drawable.ic_shuffle_none).getConstantState())
            postion++;
        else
            postion = (int) (Math.random() * list.size());
        if (postion == list.size())
            postion = 0;
        if (player.isPlaying()) {
            player.stop();
            player.release();
        }
        binding.layoutPlayer.musicPlay.setImageResource(R.drawable.ic_pause);
        binding.bmusicPlay.setImageResource(R.drawable.ic_pause);
        binding.layoutPlayer.fmusicPlay.setImageResource(R.drawable.ic_pause);
        newTrack();
        player.start();
        setEndTime();
        setRealTime();
    }

    public void favor() {
        if (binding.layoutPlayer.musicFavorite.getDrawable().getConstantState()
                == context.getResources().getDrawable(R.drawable.ic_favorite).getConstantState()) {
            binding.layoutPlayer.musicFavorite.setImageResource(R.drawable.ic_favorited);
            dao.insertFavorSong(list.get(postion));
        } else {
            Song song = list.get(postion);
            binding.layoutPlayer.musicFavorite.setImageResource(R.drawable.ic_favorite);
            for (int i = 0; i < dao.getFavorList().size(); i++) {
                String s = dao.getFavorList().get(i).getTitle();
                if (s.equals(song.getTitle())) {
                    dao.deleteFavor(dao.getFavorList().get(i).getId());
                    break;
                }
            }
        }
    }

    public void setEndTime() {
        SimpleDateFormat minutes = new SimpleDateFormat("mm:ss");
        binding.layoutPlayer.musicEnd.setText(minutes.format(player.getDuration()));
        binding.layoutPlayer.musicSeek.setMax(player.getDuration());
    }

    public void setRealTime() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat minutes = new SimpleDateFormat("mm:ss");
                binding.layoutPlayer.musicStart.setText(minutes.format(player.getCurrentPosition()));
                binding.layoutPlayer.musicSeek.setProgress(player.getCurrentPosition());
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Drawable.ConstantState state = binding.layoutPlayer.musicRepeat.getDrawable().getConstantState();
                        if (state == context.getResources().getDrawable(R.drawable.ic_repeat_none).getConstantState()) {
                            {
                                player.stop();
                                binding.layoutPlayer.musicDisc.clearAnimation();
                            }
                        }
                        if (state == context.getResources().getDrawable(R.drawable.ic_repeat_one).getConstantState()) {
                            player.start();
                            if (binding.layoutPlayer.musicDisc.getAnimation() != FragMusic.anim)
                                binding.layoutPlayer.musicDisc.startAnimation(FragMusic.anim);
                        }
                        if (state == context.getResources().getDrawable(R.drawable.ic_repeat_all).getConstantState()) {
                            next();
                            if (binding.layoutPlayer.musicDisc.getAnimation() != FragMusic.anim)
                                binding.layoutPlayer.musicDisc.startAnimation(FragMusic.anim);
                        }
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    public void onBarProgress() {
        SimpleDateFormat minutes = new SimpleDateFormat("mm:ss");
        binding.layoutPlayer.musicStart.setText(minutes.format(binding.layoutPlayer.musicSeek.getProgress()));
    }

    public void onBarStopTracking() {
        player.seekTo(binding.layoutPlayer.musicSeek.getProgress());
    }

    public class LocalBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }
}