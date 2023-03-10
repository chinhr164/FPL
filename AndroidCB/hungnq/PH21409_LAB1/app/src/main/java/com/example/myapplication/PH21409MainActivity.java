package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PH21409MainActivity extends AppCompatActivity {
    TextView txt1;
    TextView txt2;
    TextView txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txtid);
        txt1.setText("PH21409");
        txt1.setTextSize(30);

        txt2 = findViewById(R.id.txtName);
        txt2.setText("Cao Văn Chỉnh");
        txt2.setTextSize(25);

        txt3 = findViewById(R.id.txtClass);
        txt3.setText("CP17306");
        txt3.setTextSize(25);
    }
}