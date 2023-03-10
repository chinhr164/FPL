package com.example.chinhcvph21409_lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        TextView tv = findViewById(R.id.tv_Answer2);

        RadioButton rdoA = findViewById(R.id.rdo_a2a);
        rdoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });

        RadioButton rdoB = findViewById(R.id.rdo_a2b);
        rdoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });

        RadioButton rdoC = findViewById(R.id.rdo_a2c);
        rdoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án chính xác.");
                Thread waitTime = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        } finally {
                            Intent intent = new Intent(Question2.this, Question3.class);
                            startActivity(intent);
                        }
                    }
                };
                waitTime.start();
            }
        });

        RadioButton rdoD = findViewById(R.id.rdo_a2d);
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