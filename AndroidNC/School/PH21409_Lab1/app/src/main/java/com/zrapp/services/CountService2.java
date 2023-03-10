package com.zrapp.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class CountService2 extends IntentService {
    IBinder iBinder = new LocalBinder();

    public CountService2() {
        super("CountService2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int demKyTu(String str) {
        return str.length();
    }

    public int demTu(String str) {
        char[] arr = str.toCharArray();
        int w = 1;
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == ' ' && i < str.length() - 1)
                w++;
        }
        return w;
    }

    public int demNA(String str) {
        char vow[] = {'u', 'U', 'e', 'E', 'o', 'O', 'a', 'A', 'i', 'I'};
        char[] arr = str.toCharArray();
        int v = 0;
        for (int i = 0; i < str.length(); i++) {
            for (char ch : vow) {
                if (ch == arr[i]) {
                    v++;
                    break;
                }
            }
        }
        return v;
    }

    public int demPA(String str) {
        char con[] = {'b', 'B', 'c', 'C', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J',
                'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'p', 'P', 'q', 'Q', 'r', 'R',
                's', 'S', 't', 'T', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};
        char[] arr = str.toCharArray();
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            for (char ch : con) {
                if (ch == arr[i]) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }

    public int demKC(String str) {
        int s = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == ' ') {
                s++;
            }
        }
        return s;
    }


    public class LocalBinder extends Binder {
        LocalBinder getLocalBinder() {
            return LocalBinder.this;
        }
    }

}