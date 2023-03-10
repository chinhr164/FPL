package com.example.lab8bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnDuyet;
    EditText edUrl;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDuyet = findViewById(R.id.btnDuyet);
        edUrl = findViewById(R.id.edUrl);
        web = findViewById(R.id.web);


//        String link = "https://kenh14.vn/";



        btnDuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = edUrl.getText().toString();
                web.loadUrl(link);
                web.setWebViewClient(new WebViewClient());
            }
        });


    }

}