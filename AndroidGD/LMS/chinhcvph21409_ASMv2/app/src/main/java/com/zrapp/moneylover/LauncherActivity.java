package com.zrapp.moneylover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Toast.makeText(LauncherActivity.this, "Made by ChinhRoronoa", Toast.LENGTH_SHORT).show();
        Toast.makeText(LauncherActivity.this, "Support by AssassinCode", Toast.LENGTH_SHORT).show();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 4200);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(LauncherActivity.this, "Thank You", Toast.LENGTH_SHORT).show();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, 2500);
    }
}