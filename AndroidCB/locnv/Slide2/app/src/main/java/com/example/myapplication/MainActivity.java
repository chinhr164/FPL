package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    TextView total;
    Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        total = findViewById(R.id.txt3);

        btnTotal = findViewById(R.id.btnTotal);
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(txt1.getText().toString());
                    int b = Integer.parseInt(txt2.getText().toString());

//                    total.setText("Tổng: " + (a + b));
                    Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                    intent.putExtra("show",(a+b));
                    startActivity(intent);
                } catch (Exception e) {
                }
            }
        });
    }
}