package com.zrapp.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public static String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextInputLayout layout = findViewById(R.id.tvUrl);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = layout.getEditText().getText().toString();
                if (url.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Đã nhập đường dẫn đâu >.<!!", Toast.LENGTH_LONG).show();
                } else {
                    NewsDownload downloadTinTuc = new NewsDownload(MainActivity.this);
                    downloadTinTuc.execute(url);
                }
            }
        });
    }
}