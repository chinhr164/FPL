package com.zrapp.entertainment.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zrapp.entertainment.R;

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String link = bundle.getString("link");

        Toolbar toolbar = findViewById(R.id.wv_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}