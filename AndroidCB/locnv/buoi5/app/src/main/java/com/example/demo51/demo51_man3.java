package com.example.demo51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class demo51_man3 extends AppCompatActivity {
    TextView tv1;
    Button btn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo51_man3);

        tv1 = findViewById(R.id.demo51_man3_tv1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String t1 = bundle.getString("result");
            tv1.setText(t1);

            btn = findViewById(R.id.demo51_man3_btn1);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(getApplicationContext(), demo51.class);
                    startActivity(intent1);
                }
            });
        }
    }
}