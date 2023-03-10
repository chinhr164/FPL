package com.example.chinhcvph21409_lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        TextView tv = findViewById(R.id.tv_Answer3);

        RadioButton rdoA = findViewById(R.id.rdo_a3a);
        rdoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án chính xác.");
                Thread waitTime = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        } finally {
                            Intent intent = new Intent(Question3.this, FinalActivity.class);
                            startActivity(intent);
                        }
                    }
                };
                waitTime.start();
            }
        });

        RadioButton rdoB = findViewById(R.id.rdo_a3b);
        rdoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });

        RadioButton rdoC = findViewById(R.id.rdo_a3c);
        rdoC.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                tv.setText("Đáp án sai. Vui lòng chọn đáp án khác.");
            }
        });

        RadioButton rdoD = findViewById(R.id.rdo_a3d);
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