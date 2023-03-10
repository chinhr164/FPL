package com.example.webviewhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpActivity extends AppCompatActivity {
    EditText http_ed;
    Button btnSend;
    WebView http;

    String link = "https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        http_ed = findViewById(R.id.http_ed);
        btnSend = findViewById(R.id.http_btn);
        http = findViewById(R.id.http);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = http_ed.getText().toString();

                AsyncTask task = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        try {

                            URL url = new URL(link);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            InputStream stream = connection.getInputStream();
                            return BitmapFactory.decodeStream(stream);
                        } catch (Exception e) {

                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);
                        http.loadUrl(link);
                        http.setWebViewClient(new WebViewClient());
                    }
                };
                task.execute();
            }
        });
    }
}