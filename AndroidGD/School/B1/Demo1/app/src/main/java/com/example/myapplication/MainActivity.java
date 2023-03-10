package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edResult, edA, edB, edC;
    Button btnAdd, btnMulti, btnPTB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edResult = findViewById(R.id.edResult);
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edC = findViewById(R.id.edC);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soA = edA.getText().toString();
                String soB = edB.getText().toString();
                String soC = edC.getText().toString();

                if (soA.equals("") || soB.equals("") || soC.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ 3 số", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        double a = Double.parseDouble(soA);
                        double b = Double.parseDouble(soB);
                        double c = Double.parseDouble(soC);

                        edResult.setText((a + b + c) + "");
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Giá trị nhập vào cần là số!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnMulti = findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soA = edA.getText().toString();
                String soB = edB.getText().toString();
                String soC = edC.getText().toString();

                if (soA.equals("") || soB.equals("") || soC.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ 3 số", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        double a = Double.parseDouble(soA);
                        double b = Double.parseDouble(soB);
                        double c = Double.parseDouble(soC);

                        edResult.setText((a * b * c) + "");
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Giá trị nhập vào cần là số!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnPTB2 = findViewById(R.id.btnPTB2);
        btnPTB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soA = edA.getText().toString();
                String soB = edB.getText().toString();
                String soC = edC.getText().toString();

                if (soA.equals("") || soB.equals("") || soC.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ 3 số", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        double a = Double.parseDouble(soA);
                        double b = Double.parseDouble(soB);
                        double c = Double.parseDouble(soC);

                        if (a == 0) {
                            if (b == 0) {
                                if (c == 0) {
                                    edResult.setText("Vô số nghiệm!!");
                                } else {
                                    edResult.setText("Vô nghiệm!!");
                                }
                            } else {
                                if (c == 0) {
                                    edResult.setText("0.0");
                                } else {
                                    edResult.setText((-c / b) + "");
                                }
                            }
                        } else {
                            double delta = b * b - 4 * a * c;
                            if (delta < 0) {
                                edResult.setText("Vô nghiệm!!");
                            } else if (delta == 0) {
                                edResult.setText(((-b) / (2 * a)) + "");
                            }
                        }
                        edResult.setText((a * b * c) + "");
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Giá trị nhập vào cần là số!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}