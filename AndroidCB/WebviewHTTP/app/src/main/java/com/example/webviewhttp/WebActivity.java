package com.example.webviewhttp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.webView);

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.BLUETOOTH)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(WebActivity.this,
                    new String[]{Manifest.permission.BLUETOOTH},
                    999);
        } else {
            Intent intent = getIntent();
            String url = intent.getStringExtra("data");
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent intent = new Intent(getApplicationContext(), PH21409MainActivity.class);
        startActivity(intent);
    }
}