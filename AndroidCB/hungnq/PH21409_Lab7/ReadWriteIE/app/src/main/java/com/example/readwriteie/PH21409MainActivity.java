package com.example.readwriteie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PH21409MainActivity extends AppCompatActivity {
    Button btnInte, btnExte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInte = findViewById(R.id.main_btnInte);
        btnInte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InternalActivity.class);
                startActivity(intent);
            }
        });

        btnExte = findViewById(R.id.main_btnExte);
        btnExte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExternalActivity.class);
                startActivity(intent);
            }
        });
    }
}