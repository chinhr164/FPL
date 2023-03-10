package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PH21409MainActivity extends AppCompatActivity {
    EditText edt1, edt2;

    Button add, sub, multi, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        add = findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float a = Float.parseFloat(edt1.getText().toString());
                    float b = Float.parseFloat(edt2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), PH21409ManHinhHienThi.class);
                    intent.putExtra("show", Float.toString(a + b));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(PH21409MainActivity.this, "Vui lòng nhập số", Toast.LENGTH_LONG).show();
                }
            }
        });

        sub = findViewById(R.id.btnSub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float a = Float.parseFloat(edt1.getText().toString());
                    float b = Float.parseFloat(edt2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), PH21409ManHinhHienThi.class);
                    intent.putExtra("show", Float.toString(a - b));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(PH21409MainActivity.this, "Vui lòng nhập số", Toast.LENGTH_LONG).show();
                }
            }
        });

        multi = findViewById(R.id.btnMulti);
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float a = Float.parseFloat(edt1.getText().toString());
                    float b = Float.parseFloat(edt2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), PH21409ManHinhHienThi.class);
                    intent.putExtra("show", Float.toString(a * b));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(PH21409MainActivity.this, "Vui lòng nhập số", Toast.LENGTH_LONG).show();
                }
            }
        });

        div = findViewById(R.id.btnDiv);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float a = Float.parseFloat(edt1.getText().toString());
                    float b = Float.parseFloat(edt2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), PH21409ManHinhHienThi.class);
                    if (b != 0)
                        intent.putExtra("show", Float.toString(a / b));
                    else
                        intent.putExtra("show", "Không tồn tại phép chia cho 0!");
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(PH21409MainActivity.this, "Vui lòng nhập số", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
