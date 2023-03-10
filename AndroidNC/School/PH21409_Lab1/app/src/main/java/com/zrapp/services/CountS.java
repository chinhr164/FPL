package com.zrapp.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Timer;
import java.util.TimerTask;

public class CountS extends AppCompatActivity {
    TextInputLayout layout;
    Button btnFind;
    Intent intent;
    CountService2 count;
    TextView countA, countW, countV, countC, countS;
    LinearLayout linearLayout;

    ServiceConnection sv_con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CountService2.LocalBinder lBinder = (CountService2.LocalBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_s);


        Animation animationUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        Animation animationDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        count = new CountService2();
        intent = new Intent(CountS.this, CountService2.class);
        layout = findViewById(R.id.Find_name);
        countA = findViewById(R.id.count_A);
        countW = findViewById(R.id.count_W);
        countV = findViewById(R.id.count_V);
        countC = findViewById(R.id.count_C);
        countS = findViewById(R.id.count_S);
        linearLayout = findViewById(R.id.count_layout);
        bindService(intent, sv_con, BIND_AUTO_CREATE);
        btnFind = findViewById(R.id.Find_btnFind);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = layout.getEditText().getText().toString();
                if (s.isEmpty())
                    Toast.makeText(CountS.this, "Đã nhập đâu mà >.<!", Toast.LENGTH_LONG).show();
                else {
                    countA.setText(count.demKyTu(s) + "");
                    countW.setText(count.demTu(s) + "");
                    countV.setText(count.demNA(s) + "");
                    countC.setText(count.demPA(s) + "");
                    countS.setText((count.demKyTu(s) - count.demNA(s) - count.demPA(s) - count.demKC(s)) + "");

                    /* Bắt đầu xử lý ẩn/hiện thông tin */
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout.startAnimation(animationDown);
                }
            }
        });
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                linearLayout.setVisibility(View.GONE);
//                linearLayout.startAnimation(animationUp);
//            }
//        }, 5000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(CountS.this, "Dừng dịch vụ!!", Toast.LENGTH_LONG).show();
        stopService(intent);
    }
}