package com.zrapp.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnString, btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);

        btnString = findViewById(R.id.btnString);
        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StringActivity.class);
                startActivity(intent);
            }
        });

        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        });
    }
}