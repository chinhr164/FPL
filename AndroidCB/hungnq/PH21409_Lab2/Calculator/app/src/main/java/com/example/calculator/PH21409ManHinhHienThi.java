package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PH21409ManHinhHienThi extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_hien_thi);

        txt = findViewById(R.id.txt);

        Intent intent = getIntent();
        String result = intent.getExtras().getString("show");
        txt.setText(result);
    }
}