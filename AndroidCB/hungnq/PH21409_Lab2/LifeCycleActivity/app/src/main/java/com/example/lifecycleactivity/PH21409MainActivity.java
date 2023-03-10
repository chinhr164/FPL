package com.example.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class PH21409MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test","Hàm onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test","Hàm onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test","Hàm onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test","Hàm onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("test","Hàm onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test","Hàm onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test","Hàm onDestroy");
    }
}