package com.zrapp.b1services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer player;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "Khởi động", Toast.LENGTH_LONG).show();

        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Huỷ service", Toast.LENGTH_LONG).show();
        player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}