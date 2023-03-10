package com.example.pt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, et3;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(et1.getText().toString());
                double b = Double.parseDouble(et2.getText().toString());
                double c = Double.parseDouble(et3.getText().toString());
                System.out.println(a + "" + b + "" + c);
                try {
                    if (a == 0) {
                        if (b == 0) {
                            if (c == 0) {
                                tv.setText("Kết quả: Vô số nghiệm.");
                            } else {
                                tv.setText("Kết quả: Vô nghiệm.");
                            }
                        } else if (c == 0) {
                            tv.setText("Kết quả: Có 1 nghiệm: 0");
                        } else {
                            tv.setText("Kết quả: Có 1 nghiệm: " + ((-c) / b));
                        }
                    } else {
                        double delta = b * b - (4 * a * c);
                        if (delta < 0) {
                            tv.setText("Kết quả: Vô nghiệm.");
                        } else if (delta == 0) {
                            tv.setText("Kết quả: Có nghiệm kép: " + ((-b) / (2 * a)));
                        } else {
                            tv.setText("Kết quả: " + "x1 = " + ((-b) + Math.sqrt(delta)) / (2 * a) +
                                    "\nx2 = " + ((-b) - Math.sqrt(delta)) / (2 * a));
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}