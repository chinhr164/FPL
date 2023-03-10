package com.zrapp.imgdownload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGPS = findViewById(R.id.btnGPS);
        btnGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GPS.class);
                startActivity(intent);
            }
        });

        Button btnIMG = findViewById(R.id.btnIMG);
        btnIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IMG.class);
                startActivity(intent);
            }
        });
    }
}