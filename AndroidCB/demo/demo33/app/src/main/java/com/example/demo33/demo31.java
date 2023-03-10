package com.example.demo33;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class demo31 extends AppCompatActivity {
    EditText ed1, ed2;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31);
        ed1 = findViewById(R.id.demo31_ed1);
        ed2 = findViewById(R.id.demo31_ed2);
        btn1 = findViewById(R.id.demo31_btn1);
        btn2 = findViewById(R.id.demo31_btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equalsIgnoreCase("admin")
                        && ed2.getText().toString().equalsIgnoreCase("admin")) {
                    Toast.makeText(demo31.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(demo31.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}