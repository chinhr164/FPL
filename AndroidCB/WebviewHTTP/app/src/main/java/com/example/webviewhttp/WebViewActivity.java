package com.example.webviewhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {
    EditText wv_ed;
    Button wv_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wv_ed = findViewById(R.id.wv_ed);
        wv_btn = findViewById(R.id.wv_btn);
        wv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                intent.putExtra("data", wv_ed.getText() + "");
                startActivity(intent);
            }
        });
    }
}