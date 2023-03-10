package com.example.webviewhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button main_btnWebV, main_btnHTTP, main_btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_btnWebV = findViewById(R.id.main_btnWebV);
        main_btnWebV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(intent);
            }
        });

        main_btnHTTP = findViewById(R.id.main_btnHTTP);
        main_btnHTTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HttpActivity.class);
                startActivity(intent);
            }
        });

        main_btnExit = findViewById(R.id.main_btnExit);
        main_btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            }
        });
    }
}