package com.zrapp.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentS extends AppCompatActivity {
    Button btnStart, btnClose;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_s);

        intent = new Intent(StudentS.this, StudentService.class);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putString("ID", "PH21409");
                b.putString("name", "Cao Văn Chỉnh");
                b.putString("class", "CP17304");
                intent.putExtra("extra", b);
                startService(intent);
            }
        });

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentS.this, "Dừng dịch vụ!!", Toast.LENGTH_LONG).show();
                stopService(intent);
            }
        });
    }
}