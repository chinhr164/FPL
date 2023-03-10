package com.zrapp.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class CountService extends IntentService {
    public static final String CHANNEL_ID = "exampleServiceChannel";
    Notification notification = null;

    public CountService() {
        super("CountService");
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID, "Example Service Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(serviceChannel);
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle b = intent.getBundleExtra("s");
        String s = b.getString("s");
        if (s.isEmpty()) {
            Toast.makeText(this, "Đã nhập gì đâu mà đếm >.<", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Đếm được rồi đó B==D", Toast.LENGTH_LONG).show();
            RemoteViews notify = new RemoteViews(getPackageName(), R.layout.custom_notify);


            //Xử lý chuỗi
            char vow[] = {'u', 'U', 'e', 'E', 'o', 'O', 'a', 'A', 'i', 'I'};
            char con[] = {'b', 'B', 'c', 'C', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J',
                    'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'p', 'P', 'q', 'Q', 'r', 'R',
                    's', 'S', 't', 'T', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};
            int w = 1, v = 0, c = 0, sp = 0;
            char[] arr = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (arr[i] == ' ') sp++;
                if (arr[i] == ' ' && i < s.length() - 1)
                    w++;
                for (char ch : vow) {
                    if (ch == arr[i]) {
                        v++;
                        break;
                    }
                }
                for (char ch : con) {
                    if (ch == arr[i]) {
                        c++;
                        break;
                    }
                }
            }
            //Số ký tự
            notify.setTextViewText(R.id.notify_countA, "Số ký tự: " + s.length());
            //Số từ
            notify.setTextViewText(R.id.notify_countWord, "Số từ: " + w);
            //Số nguyên âm
            notify.setTextViewText(R.id.notify_countVowel, "Số nguyên âm: " + v);
            //Số phụ âm
            notify.setTextViewText(R.id.notify_countConsonant, "Số phụ âm: " + c);
            //Số ký tự đặc biệt
            notify.setTextViewText(R.id.notify_countSpecial, "Số ký tự đặc biệt: " + (s.length() - c - v - sp));


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setContentTitle("Thông tin đếm được:")
                        .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                        .setCustomBigContentView(notify)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .build();

                startForeground(1, notification);
            }
        }
    }
}