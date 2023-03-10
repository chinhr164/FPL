package com.example.bai2lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    WebView webView;

    String link = "https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        webView = findViewById(R.id.webView);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask task = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        try {

                            URL url = new URL(link);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            InputStream stream = connection.getInputStream();
                            return BitmapFactory.decodeStream(stream);
                        }catch (Exception e){

                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);
                        webView.loadUrl(link);
                        webView.setWebViewClient(new WebViewClient());
                    }
                };
                task.execute();
            }
        });

    }




}