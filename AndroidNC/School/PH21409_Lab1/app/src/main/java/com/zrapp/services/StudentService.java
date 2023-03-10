package com.zrapp.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class StudentService extends Service {
    public static final String CHANNEL_ID = "exampleServiceChannel";
    Notification notification = null;

    public StudentService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID, "Example Service Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(serviceChannel);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Thêm SV thành công", Toast.LENGTH_LONG).show();
        Bundle b = intent.getBundleExtra("extra");
        String id, name, clas;
        id = b.getString("ID");
        name = b.getString("name");
        clas = b.getString("class");
        String content = "Mã SV: " + id + " - Tên: " + name + " - Lớp: " + clas;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Sinh viên đã thêm")
                    .setContentText(content)
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .build();

            startForeground(1, notification);
        }

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
}