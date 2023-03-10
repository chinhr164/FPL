package com.zrapp.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    private static final int MSG_UPDATE_NUMBER = 100;
    private static final int MSG_UPDATE_NUMBER_DONE = 101;

    private TextView mTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        countNumbers();
        listenerHandler();
    }

    private void initViews() {
        mTextNumber = findViewById(R.id.tv);
    }

    private void countNumbers() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    Message message = new Message();
                    message.what = MSG_UPDATE_NUMBER;
                    message.arg1 = i;
                    mHandler.sendMessage(message);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mHandler.sendEmptyMessage(MSG_UPDATE_NUMBER_DONE);
            }
        }).start();
    }

    private void listenerHandler() {
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MSG_UPDATE_NUMBER:
                        mTextNumber.setText(String.valueOf(msg.arg1));
                        break;
                    case MSG_UPDATE_NUMBER_DONE:
                        mTextNumber.setText("Done!");
                        break;
                    default:
                        break;
                }
            }
        };
    }
}
