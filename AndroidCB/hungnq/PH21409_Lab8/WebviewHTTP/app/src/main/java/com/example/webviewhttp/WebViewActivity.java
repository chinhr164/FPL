package com.example.webviewhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {
    EditText wv_ed;
    Button wv_btn;
    WebView webView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wv_ed = findViewById(R.id.wv_ed);
        webView = findViewById(R.id.webView);
        wv_btn = findViewById(R.id.wv_btn);
        wv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = wv_ed.getText().toString();
                webView.loadUrl(link);
                webView.setWebViewClient(new WebViewClient());
            }
        });
    }
}