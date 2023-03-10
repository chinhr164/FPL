package com.example.chinhcvph21409_lab12_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnC, btnL, btnR, btnG;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConstraintDkActivity.class);
                startActivity(intent);
            }
        });

        btnL = findViewById(R.id.btnL);
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LinearDkActivity.class);
                startActivity(intent);
            }
        });

        btnR = findViewById(R.id.btnR);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RelativeDkActivity.class);
                startActivity(intent);
            }
        });

        btnG = findViewById(R.id.btnG);
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridMtActivity.class);
                startActivity(intent);
            }
        });
    }
}