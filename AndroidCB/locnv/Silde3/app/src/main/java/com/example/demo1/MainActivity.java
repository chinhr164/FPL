package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.ed1);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = tv1.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("man1",a);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        super.onRestart();
        tv1 = findViewById(R.id.ed1);

        Intent intent = getIntent();
        String b = intent.getStringExtra("man2");
        System.out.println(b);
        tv1.setText(b);
    }
}