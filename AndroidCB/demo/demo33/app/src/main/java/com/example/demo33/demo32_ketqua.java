package com.example.demo33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class demo32_ketqua extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo32_ketqua);

        tv1 = findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            double a = bundle.getDouble("a", 0);
            double b = bundle.getDouble("b", 0);
            double c = bundle.getDouble("c", 0);

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        tv1.setText("Phương trình vô số nghiệm.");
                    } else {
                        tv1.setText("Phương trình vô nghiệm.");
                    }
                } else if (c == 0) {
                    tv1.setText("Phương trình có 1 nghiệm: 0");
                } else {
                    double result = (-c) / b;
                    tv1.setText("Phương trình có 1 nghiệm: " + (Math.round(result * 10 * 10.0) / (10 * 10.0)));
                }
            } else {
                double delta = b * b - (4 * a * c);
                if (delta < 0) {
                    tv1.setText("Phương trình vô nghiệm.");
                } else if (delta == 0) {
                    double result = (-b) / (2 * a);
                    tv1.setText("Phương trình có nghiệm kép: " + (Math.round(result * 10 * 10.0) / (10 * 10.0)));
                } else {
                    double result1 = ((-b) + Math.sqrt(delta)) / (2 * a);
                    double result2 = ((-b) - Math.sqrt(delta)) / (2 * a);
                    tv1.setText("Phương trình có hai nghiệm phân biệt" + "\n\tx1 = " + (Math.round(result1 * 10 * 10.0) / (10 * 10.0)) +
                            "\n\tx2 = " + (Math.round(result2 * 10 * 10.0) / (10 * 10.0)));
                }
            }
        }
    }
}
