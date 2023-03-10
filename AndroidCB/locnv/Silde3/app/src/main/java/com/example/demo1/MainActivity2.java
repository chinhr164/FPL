package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv2;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv2 = findViewById(R.id.ed2);

        Intent intent = getIntent();
        String a = intent.getStringExtra("man1");
        tv2.setText(a);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b = tv2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("man2", b);
                startActivity(intent);
            }
        });
    }
}