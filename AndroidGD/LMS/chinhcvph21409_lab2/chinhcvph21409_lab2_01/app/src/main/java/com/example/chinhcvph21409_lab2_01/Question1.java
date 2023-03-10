package com.example.chinhcvph21409_lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quession1);

        TextView tv = findViewById(R.id.tv_Answer1);

        RadioButton rdoA = findViewById(R.id.rdo_a1a);
        rdoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });

        RadioButton rdoB = findViewById(R.id.rdo_a1b);
        rdoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án chính xác.");
                Thread waitTime = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        } finally {
                            Intent intent = new Intent(Question1.this, Question2.class);
                            startActivity(intent);
                        }
                    }
                };
                waitTime.start();
            }
        });

        RadioButton rdoC = findViewById(R.id.rdo_a1c);
        rdoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });

        RadioButton rdoD = findViewById(R.id.rdo_a1d);
        rdoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}