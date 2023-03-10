package com.example.ptb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PH21409Result extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph21409_result);

        tvResult = findViewById(R.id.tvResult);

        Intent intent = getIntent();
        double a = intent.getDoubleExtra("a", 0);
        double b = intent.getDoubleExtra("b", 0);
        double c = intent.getDoubleExtra("c", 0);

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    tvResult.setText("Phương trình vô số nghiệm.");
                } else {
                    tvResult.setText("Phương trình vô nghiệm.");
                }
            } else if (c == 0) {
                tvResult.setText("Phương trình có 1 nghiệm: 0");
            } else {
                double result = (-c) / b;
                tvResult.setText("Phương trình có 1 nghiệm: " + (Math.round(result * 10 * 10.0) / (10 * 10.0)));
            }
        } else {
            double delta = b * b - (4 * a * c);
            if (delta < 0) {
                tvResult.setText("Phương trình vô nghiệm.");
            } else if (delta == 0) {
                double result = (-b) / (2 * a);
                tvResult.setText("Phương trình có nghiệm kép: " + (Math.round(result * 10 * 10.0) / (10 * 10.0)));
            } else {
                double result1 = ((-b) + Math.sqrt(delta)) / (2 * a);
                double result2 = ((-b) - Math.sqrt(delta)) / (2 * a);
                tvResult.setText("Phương trình có hai nghiệm phân biệt" + "\n\tx1 = " + (Math.round(result1 * 10 * 10.0) / (10 * 10.0)) +
                        "\n\tx2 = " + (Math.round(result2 * 10 * 10.0) / (10 * 10.0)));
            }
        }
    }
}