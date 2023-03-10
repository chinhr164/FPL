package com.example.demo33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UCharacterEnums;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class demo32 extends AppCompatActivity {
    EditText ed1, ed2, ed3;

    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo32);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. Lấy dữ liệu
                double a = Double.parseDouble(ed1.getText().toString());
                double b = Double.parseDouble(ed2.getText().toString());
                double c = Double.parseDouble(ed3.getText().toString());

                //2. Tạo intent
                Intent intent = new Intent(getApplicationContext(), demo32_ketqua.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("a", a);
                bundle.putDouble("b", b);
                bundle.putDouble("c", c);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}